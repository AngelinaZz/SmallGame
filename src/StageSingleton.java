import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class StageSingleton {
    private static Stage stage;

    public static String userName;

    public static synchronized Stage getStage() {
        return stage;
    }

    public static synchronized void setStage(Stage s) {
        stage = s;
    }

    //如果这个事件除了剧情、姓名和是否弹出以外，还要添加背景图片或者人物图片，就在这里添加
    static StringEvent eventSusei = new StringEvent("（宿舍的条件也很简陋啊，不过幸好睡在下铺还比较方便呢。\n说起来，我边上那个4号下铺怎么一直黑着脸啊。。。)", "???", 0);
    static StringEvent pwt = new StringEvent("-20min后-\n哎呦，你好呀！我叫潘文韬！", "同桌", 0);
    static StringEvent xzy_self_introduction = new StringEvent("你好你好，我叫#（这同桌，该不会是个智障吧）", "???", 0);
    static StringEvent whx = new StringEvent("大家好，我是你们的班主任兼物理老师王含喜。请大家先填一下发到手中的个人信息采集表！", "班主任", 2);
    static StringEvent whx2 = new StringEvent("下面的时间就给大家自由活动了，明天就要开始上课了。希望以后能和大家好好相处。", "含喜", 0);
    static StringEvent whx3 = new StringEvent("现在大家出去从矮到高排一下队，我们把座位排了。", "含喜", 0);
    static StringEvent ly = new StringEvent("我们来自我介绍一下吧，我叫刘悦，灌云的，你们呢？", "4号", 0);
    static StringEvent fjx = new StringEvent("我叫伏家兴，板浦那边来的。", "1号", 0);
    static StringEvent la = new StringEvent("我叫李昂，也是灌云的。", "3号", 0);
    static StringEvent xqx = new StringEvent("我是许琪祥，也是海州来的。", "6号", 0);
    static StringEvent ly2 = new StringEvent("5号呢？你叫什么？", "刘悦", 0);
    static StringEvent fyh = new StringEvent(".......\n啊？我啊，呵呵，我叫费毓晗。", "5号", 0);
    static StringEvent ly3 = new StringEvent("你哪来的？", "刘悦", 0);
    static StringEvent fyh2 = new StringEvent(".....\n我是没考好来的。", "费毓晗", 0);
    static StringEvent eventjiaoshi = new StringEvent("（已经习惯了和舍友相处，和班里的人也开始熟悉起来了。\n说起这个班好看的女孩子还真不少呢，嘻嘻）", "???", 0);
    static StringEvent yz = new StringEvent("诶诶你看那个男生好瘦啊！我觉得比女生还瘦的男生就该被关起来！", "女生A", 1);
    static StringEvent  xzy = new StringEvent("（算了，还是不要太在意了吧。）", "???", 0);

    static StringEvent  fyh3 = new StringEvent("：席子轶啊记得帮我打一下水啊。", "费毓晗", 0);


    static {
        whx.setHumanImgVisible(true);
        whx.setHumanImgSrc("whx.jpg");
        pwt.setHumanImgVisible(true);
        pwt.setHumanImgSrc("pwt.jpg");
        whx2.setHumanImgVisible(true);
        whx2.setHumanImgSrc("whx.jpg");
        whx3.setHumanImgVisible(true);
        ly.setHumanImgVisible(true);
        ly.setHumanImgSrc("ly.jpg");
        setHumanImg(fjx, "fjx.jpg");
        setHumanImg(la, "la.jpg");
        setHumanImg(xqx, "xqx.jpg");
        setHumanImg(ly2, "ly.jpg");
        setHumanImg(fyh, "fyh.jpg");
        setHumanImg(ly3, "ly.jpg");
        setHumanImg(fyh2, "fyh.jpg");
        //  xzy_self_introduction.setHumanImgVisible(false);
        eventSusei.setBackImgSrc("susei.jpg");
        eventjiaoshi.setBackImgSrc("jiaoshi.jpg");
        setHumanImg(yz, "yz.jpg");
        setHumanImg(fyh3, "fyh3.jpg");
        xzy.setBackImgSrc("jiaoshi.jpg");

    }

    public static void setHumanImg(StringEvent stringEvent, String src) {
        stringEvent.setHumanImgVisible(true);
        stringEvent.setHumanImgSrc(src);
    }

    /**
     * 这里添加剧情
     */
    public static StringEvent[] stringList = new StringEvent[]{
            new StringEvent("（终于到学校了，今天好热啊。说起来，我就要在这个学校住三年了呢。\n会遇上怎样的人呢。。。。。。）", "???", 0),
            new StringEvent("（找到教室可真的不容易啊，这学校也太大了，这破教室居然连个空调都没有？\n不过，不知道班里有没有好看的女孩子的呀，嘿嘿。）", "???", 0), //如果有剧情需要弹出框
            whx,
            whx3,
            //建议像这样写两遍
            pwt,
            xzy_self_introduction,
            whx2,
            eventSusei,
            new StringEvent("（4号突然抬头）", "4号", 0),
            ly,
            fjx,
            new StringEvent("我叫#，我是海州那边的。", "???", 0),
            la,
            xqx,
            ly2,
            fyh,
            ly3,
            fyh2,
            new StringEvent("（这个人，很厉害啊？）", "???", 0),
            eventjiaoshi,
            new StringEvent("（中午下课铃）", "下课铃", 0),
            yz,
            new StringEvent("（那个女生好像是叫...杨喆？）", "???", 0),
            new StringEvent("（算了，还是不要太在意了吧。）", "???", 0),
            fyh3,
            new StringEvent("（微笑脸）\n（这个人天天跟异地的女朋友打电话，然后叫我给他打水，可真过分）", "???", 0),
            new StringEvent("（这个人，很厉害啊？）", "???", 0),


            new StringEvent("剧情5..........", userName, 0)
    };

    public static int index = 0;

    public static Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 600, 456);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }
}
