package us.sunrisemorning.mykancolle.index;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.core.Controller;

import us.sunrisemorning.mykancolle.model.Basic;
import us.sunrisemorning.mykancolle.model.Deck;
import us.sunrisemorning.mykancolle.model.Kdock;
import us.sunrisemorning.mykancolle.model.Material;
import us.sunrisemorning.mykancolle.model.Ndock;
import us.sunrisemorning.mykancolle.model.Params;
import us.sunrisemorning.mykancolle.model.Ship;
import us.sunrisemorning.mykancolle.model.User;

public class IndexController extends Controller {
    public static final String LOGIN_SESSION_KEY = "loginFlag";

    public void index() {
        String token = getSessionAttr(LOGIN_SESSION_KEY);
        if (StringUtils.isNotBlank(token)) {
            render("index.html");
        } else {
            redirect("/loginPage");
        }
    }

    public void loginPage() {
        render("login.html");
    }

    public void regPage() {
        render("reg.html");
    }

    public void reg() {
        String userName = getPara("userName");
        String userPass = getPara("userPass");

        User u = User.dao.findFirst("select id from User where userName=?", userName);
        if (u != null) {
            redirect("/regPage");
            return;
        }

        createNewAccount(userName, userPass);
        redirect("/loginPage");
    }

    public void login() {
        String userName = getPara("userName");
        String userPass = getPara("userPass");

        User u = User.dao.findFirst("select id from User where userName=? and userPass=?", userName, userPass);
        if (u == null) {
            redirect("/loginPage");
        } else {
            u.newToken();
            u.update();
            setSessionAttr(LOGIN_SESSION_KEY, u.getToken());
            redirect("/");
        }
    }

    private void createNewAccount(String userName, String userPass) {
        User u = new User();
        u.setUsername(userName);
        u.setUserpass(userPass);
        u.setToken("");
        u.setWorld("11");
        u.save();

        Ship ship = Ship.dao.generateShip(1, u.getId());
        ship.save();

        Params params = new Params();
        params.setUser(u.getId());
        params.setP_bgm_id(111);
        params.setParallel_quest_count(5);
        params.setMax_preset_deck(3);
        params.save();

        for (int i = 0; i < 4; i++) {
            Ndock ndock = new Ndock();
            ndock.setId(new Long(i + 1));
            ndock.setMember_id(u.getId());
            ndock.setState(i >= 2 ? -1 : 0);
            ndock.setShip_id(0);
            ndock.setComplete_time(0);
            ndock.setComplete_time_str("0");
            ndock.setItem1(0);
            ndock.setItem2(0);
            ndock.setItem3(0);
            ndock.setItem4(0);
            ndock.save();
        }

        Material.dao.generateMaterial(1, u.getId(), 4000).save();
        Material.dao.generateMaterial(2, u.getId(), 6000).save();
        Material.dao.generateMaterial(3, u.getId(), 6000).save();
        Material.dao.generateMaterial(4, u.getId(), 2000).save();
        Material.dao.generateMaterial(5, u.getId(), 400).save();
        Material.dao.generateMaterial(6, u.getId(), 300).save();
        Material.dao.generateMaterial(7, u.getId(), 200).save();
        Material.dao.generateMaterial(8, u.getId(), 100).save();

        for (int i = 0; i < 4; i++) {
            Kdock kdock = new Kdock();
            kdock.setId(new Long(i + 1));
            kdock.setMember_id(u.getId());
            kdock.setState(i >= 2 ? -1 : 0);
            kdock.setCreated_ship_id(0);
            kdock.setComplete_time(0l);
            kdock.setComplete_time_str("0");
            kdock.setItem1(0);
            kdock.setItem2(0);
            kdock.setItem3(0);
            kdock.setItem4(0);
            kdock.setItem5(0);
            kdock.save();
        }

        Deck deck = new Deck();
        deck.setId(1l);
        deck.setMember_id(u.getId());
        deck.setName("第1艦隊");
        deck.setName_id("1");
        deck.setFlagship("0");
        deck.setMission1(0l);
        deck.setMission2(0l);
        deck.setMission3(0l);
        deck.setMission4(0l);
        deck.setShip1(ship.getId());
        deck.setShip2(-1l);
        deck.setShip3(-1l);
        deck.setShip4(-1l);
        deck.setShip5(-1l);
        deck.setShip6(-1l);
        deck.save();

        Basic basic = new Basic();
        basic.setMember_id(u.getId());
        basic.setNickname(u.getUsername());
        basic.setNickname_id("3");
        basic.setActive_flag(1);
        basic.setStarttime(new Date().getTime());
        basic.setLevel(1);
        basic.setRank(1);
        basic.setExperience(0);
        basic.setComment("");
        basic.setComment_id("1");
        basic.setMax_chara(100);
        basic.setMax_slotitem(400);
        basic.setMax_kagu(0);
        basic.setPlaytime(0);
        basic.setTutorial(0);
        basic.setFurniture1(0);
        basic.setFurniture2(0);
        basic.setFurniture3(0);
        basic.setFurniture4(0);
        basic.setFurniture5(0);
        basic.setFurniture6(0);
        basic.setCount_deck(1);
        basic.setCount_kdock(2);
        basic.setCount_ndock(2);
        basic.setFcoin(1000000);
        basic.setSt_win(0);
        basic.setSt_lose(0);
        basic.setMs_count(0);
        basic.setMs_success(0);
        basic.setPt_win(0);
        basic.setPt_lose(0);
        basic.setPt_challenged(0);
        basic.setPt_challenged_win(0);
        basic.setFirstflag(1);
        basic.setTutorial_progress(100);
        basic.setLarge_dock(1);
        basic.save();
    }
}
