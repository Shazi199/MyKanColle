// ガジェット情報
var ConstGadgetInfo = {};
ConstGadgetInfo.height = 610;

// SNS 情報
var ConstSNSInfo = {};
ConstSNSInfo.id = "DMM";

// サーバー情報
var ConstServerInfo = {};
ConstServerInfo.Gadget           = "http://localhost/";
ConstServerInfo.World_1          = "http://localhost/";
ConstServerInfo.World_2          = "http://localhost/";
ConstServerInfo.World_3          = "http://localhost/";
ConstServerInfo.World_4          = "http://localhost/";
ConstServerInfo.World_5          = "http://localhost/";
ConstServerInfo.World_6          = "http://localhost/";
ConstServerInfo.World_7          = "http://localhost/";
ConstServerInfo.World_8          = "http://localhost/";
ConstServerInfo.World_9          = "http://localhost/";
ConstServerInfo.World_10         = "http://localhost/";
ConstServerInfo.World_11         = "http://localhost/";
ConstServerInfo.World_12         = "http://localhost/";
ConstServerInfo.World_13         = "http://localhost/";
ConstServerInfo.World_14         = "http://localhost/";
ConstServerInfo.World_15         = "http://localhost/";
ConstServerInfo.World_16         = "http://localhost/";
ConstServerInfo.World_17         = "http://localhost/";
ConstServerInfo.World_18         = "http://localhost/";
ConstServerInfo.World_19         = "http://localhost/";
ConstServerInfo.World_20         = "http://localhost/";

// URL 情報
var ConstURLInfo = {};
ConstURLInfo.GetUserWorldURL     = ConstServerInfo.Gadget + "kcsapi/api_world/get_id/";
ConstURLInfo.PaymentConfirmURL   = ConstServerInfo.Gadget + "";
ConstURLInfo.ConnectionCheckURL  = ConstServerInfo.Gadget + "index.html";
ConstURLInfo.ThanksFlashURL      = ConstServerInfo.Gadget + "kcs/ad.swf";
ConstURLInfo.WorldSelectFlashURL = ConstServerInfo.Gadget + "kcs/world.swf";
ConstURLInfo.MaintenanceFlashURL = ConstServerInfo.Gadget + "kcs/maintenance.swf";
ConstURLInfo.EntranceFlashURL    = ConstServerInfo.Gadget + "kcs/entrance.swf";
ConstURLInfo.WaitingFlashURL     = ConstServerInfo.Gadget + "kcs/wait.swf";
ConstURLInfo.WaitingFlashURL2    = ConstServerInfo.Gadget + "kcs/wait5.swf";
ConstURLInfo.AccessDenyFlashURL  = ConstServerInfo.Gadget + "kcs/ban.swf";
ConstURLInfo.AccessTDenyFlashURL = ConstServerInfo.Gadget + "kcs/deny.swf";
ConstURLInfo.LoginURL            = "kcsapi/api_auth_member/dmmlogin/";
ConstURLInfo.MainFlashURL        = "kcs/mainD2.swf";
ConstURLInfo.GetTokenURL         = "kcsapi/api_auth_member/get_token/";

// Message 情報
var ConstMessageInfo = {};
ConstMessageInfo.InstallFlashMessage = 
    "このゲームを遊ぶには、Adobe Flash Player が必要です。<br />" +
    "下のリンクからインストールして、ログインしなおしてください。<br />" +
    "<br />" +
    "<a href='http://www.adobe.com/go/getflashplayer' target='_blank'>Adobe Flash Player のインストール</a>";
ConstMessageInfo.UAErrorMessage = 
    "このゲームは PC 専用となっております。<br />" +
    "推奨環境をご確認の上、ご利用ください。<br />";

// Parameter 情報
var ConstParameterInfo = {};
ConstParameterInfo.PaymentResult_Paid   =  0;
ConstParameterInfo.PaymentResult_Cancel = -1;
ConstParameterInfo.GetUserWorld_IsNew   = 0;
ConstParameterInfo.APIResult_OK         = 1;

// Connection 情報
var ConnectionInfo = {};
ConnectionInfo.Interval_Min   = 10;
ConnectionInfo.TickCount      = 90;

// Maintenance 情報
var MaintenanceInfo = {};
MaintenanceInfo.IsDoing       = 0;
MaintenanceInfo.IsEmergency   = 0;
MaintenanceInfo.StartDateTime = Date.parse("2015/08/10 11:00:00");
MaintenanceInfo.EndDateTime   = Date.parse("2015/08/10 23:35:00");

// Entrance 情報
var EntranceInfo = {};
EntranceInfo.Groups           = 10;
EntranceInfo.Interval_Min     = 2;
EntranceInfo.UidIndex         = 5;

// Entrance 情報（ワールド別）
EntranceInfo.NewUser          = 2;
EntranceInfo.World_1_User     = 2;
EntranceInfo.World_2_User     = 2;
EntranceInfo.World_3_User     = 2;
EntranceInfo.World_4_User     = 2;
EntranceInfo.World_5_User     = 2;
EntranceInfo.World_6_User     = 2;
EntranceInfo.World_7_User     = 2;
EntranceInfo.World_8_User     = 2;
EntranceInfo.World_9_User     = 2;
EntranceInfo.World_10_User    = 2;
EntranceInfo.World_11_User    = 2;
EntranceInfo.World_12_User    = 2;
EntranceInfo.World_13_User    = 2;
EntranceInfo.World_14_User    = 2;
EntranceInfo.World_15_User    = 2;
EntranceInfo.World_16_User    = 2;
EntranceInfo.World_17_User    = 2;
EntranceInfo.World_18_User    = 2;
EntranceInfo.World_19_User    = 2;
EntranceInfo.World_20_User    = 2;
