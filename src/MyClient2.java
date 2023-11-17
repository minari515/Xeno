import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyClient2 extends JFrame implements MouseListener,MouseMotionListener {
	private JButton gu, tyoki, pa;//ボタン用の配列
    private JButton passbtn,sysbtn,bangou, startbtn,
    okbtn, mytehudabtn, openyou, openyou2,
    yamahuda, myhuda1, myhuda2, youhuda1,youhuda2,
    ban1, ban2, ban3, ban4, ban5, ban6, ban7, ban8, ban9, ban10, hidari, migi,
    ken1btn, ken2btn, ken3btn, xenobtn, winbutton, losebutton, drowbutton;
    private int mytehuda, myColor, myTurn, guu, tyo, paa, janken, fin, choice1, sousa, kp,
    syugo, choice5, tainum, kenja, sevenfin, ken1, ken2, ken3;
    private ImageIcon myIcon, yourIcon, okIcon, xenoIcon;
    private JLayeredPane c; 
	private ImageIcon guIcon, choIcon, paIcon, canIcon, resetIcon, Icon01, Icon02, Icon03,
    Icon04, Icon05, Icon06, Icon07, Icon08, Icon09, Icon10, Icon1, Icon2, Icon3, Icon4, Icon5, Icon6, Icon7, Icon8, Icon9,
    RIcon, LIcon, Icon110, haIcon, startIcon, Icona1, Icona2, Icona3, Icona4, Icona5, Icona6, Icona7, Icona8, Icona9, Icona10,
    slidesen, slidekou, slidehy, yamaa, yamab, ka1a, ka1b, hi1a, hi1b, ka2, hi2, ka2suc, ka2fai, hi2fai, hi2suc, ka3, hi3, ka4, hi4, ka5, hi5,
    ka6a, ka6b, hi6a, hi6b, ka7, hi7, ka8, hi8, ka9, hi9, senkou, koukou, aikoa, aikob, sentaku7, win, lose, drow, wina, losea, drowa,
    senkou1, koukou1;
    private int yamacount, fincount, mynum1, mynum2, yournum1, yournum2, mylog, youlog, kakumei, taiketsu, kouka, ninefin;
    private int huda[] = new int[18];
    private int kennum[] = new int[3];
    private String msg;
	PrintWriter out;//出力用のライター
	private JLabel haikei;
    private JButton mylogbtn[];
    private JButton youlogbtn[];

	public MyClient2() {
		//名前の入力ダイアログを開く
		String myName = JOptionPane.showInputDialog(null,"名前入力してください","名前の入力",JOptionPane.QUESTION_MESSAGE);
		if(myName.equals("")){
			myName = "No name";//名前がないときは，"No name"とする
		}

        String IP =JOptionPane.showInputDialog(null,"IPアドレスを入力してください","IPアドレスの入力",JOptionPane.QUESTION_MESSAGE);
        if(IP.equals("")){
			IP = "localhost";//名前がないときは，"localhost"とする
		}
        

		//ウィンドウを作成する
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ウィンドウを閉じるときに，正しく閉じるように設定する
		this.setTitle("XENO");//ウィンドウのタイトルを設定する
		this.setSize(1400,800);//ウィンドウのサイズを設定する
        c = new JLayeredPane(); 
        this.getContentPane().add(c);//フレームのペインを取得する
        c.setBackground(Color.lightGray);//ウィンドウの色の設定
        setResizable(false);
        c.setVisible(true);
        //c.add(new DrawCanvas());
        c.setLayout(null);//自動レイアウトの設定を行わない



		paIcon = new ImageIcon("pa.png");//画像の宣言
		guIcon = new ImageIcon("gu.png");
		choIcon = new ImageIcon("cho.png");
        Icon01 = new ImageIcon("01.png");
        Icon02 = new ImageIcon("02.png");
        Icon03 = new ImageIcon("03.png");
        Icon04 = new ImageIcon("04.png");
        Icon05 = new ImageIcon("05.png");
        Icon06 = new ImageIcon("06.png");
        Icon07 = new ImageIcon("07.png");
        Icon08 = new ImageIcon("08.png");
        Icon09 = new ImageIcon("09.png");
        Icon110 = new ImageIcon("110.png");
        Icon1 = new ImageIcon("1.png");
        Icon2 = new ImageIcon("2.png");
        Icon3 = new ImageIcon("3.png");
        Icon4 = new ImageIcon("4.png");
        Icon5 = new ImageIcon("5.png");
        Icon6 = new ImageIcon("6.png");
        Icon7 = new ImageIcon("7.png");
        Icon8 = new ImageIcon("8.png");
        Icon9 = new ImageIcon("9.png");
        Icon10 = new ImageIcon("10.png");
        LIcon = new ImageIcon("l.png");
        RIcon = new ImageIcon("r.png");
        okIcon = new ImageIcon("ok.png");
        haIcon = new ImageIcon("back.png");
        startIcon = new ImageIcon("start.jpg");
        xenoIcon = new ImageIcon("sum.png");
        Icona1 = new ImageIcon("a1.png");
        Icona2 = new ImageIcon("a2.png");
        Icona3 = new ImageIcon("a3.png");
        Icona4 = new ImageIcon("a4.png");
        Icona5 = new ImageIcon("a5.png");
        Icona6 = new ImageIcon("a6.png");
        Icona7 = new ImageIcon("a7.png");
        Icona8 = new ImageIcon("a8.png");
        Icona9 = new ImageIcon("a9.png");
        Icona10 = new ImageIcon("a10.png");
        slidehy = new ImageIcon("slide1.png");
        slidesen = new ImageIcon("slide2.png");
        slidekou = new ImageIcon("slide3.png");
        ka1a = new ImageIcon("slide4.png");
        hi1a = new ImageIcon("slide5.png");
        ka1b = new ImageIcon("slide6.png");
        hi1b = new ImageIcon("slide7.png");
        ka2 = new ImageIcon("slide8.png");
        hi2 = new ImageIcon("slide9.png");
        ka2suc = new ImageIcon("slide10.png");
        ka2fai = new ImageIcon("slide11.png");
        hi2fai = new ImageIcon("slide12.png");
        ka2suc = new ImageIcon("slide13.png");
        ka3 = new ImageIcon("slide14.png");
        hi3 = new ImageIcon("slide15.png");
        ka4 = new ImageIcon("slide16.png");
        hi4 = new ImageIcon("slide17.png");
        ka5 = new ImageIcon("slide18.png");
        hi5 = new ImageIcon("slide19.png");
        ka6a = new ImageIcon("slide20.png");
        hi6a = new ImageIcon("slide21.png");
        ka6b = new ImageIcon("slide29.png");
        hi6b = new ImageIcon("slide30.png");
        ka7 = new ImageIcon("slide22.png");
        hi7 = new ImageIcon("slide23.png");
        ka8 = new ImageIcon("slide24.png");
        hi8 = new ImageIcon("slide25.png");
        ka9 = new ImageIcon("slide26.png");
        hi9 = new ImageIcon("slide27.png");
        yamaa = new ImageIcon("slide28.png");
        yamab = new ImageIcon("slide35.png");
        senkou = new ImageIcon("slide31.png");
        koukou = new ImageIcon("slide32.png");
        aikoa = new ImageIcon("slide33.png");
        aikob = new ImageIcon("slide34.png");
        sentaku7 = new ImageIcon("slide36.png");
        drowa = new ImageIcon("slide37.png");
        wina = new ImageIcon("slide38.png");
        losea = new ImageIcon("slide39.png");
        senkou1 = new ImageIcon("slide40.png");
        koukou1 = new ImageIcon("slide41.png");
        win = new ImageIcon("win.png");
        lose = new ImageIcon("lose.png");
        drow = new ImageIcon("drow.png");
        

		ImageIcon Background = new ImageIcon("night.jpg");//背景の表示
		haikei = new JLabel(Background);
		c.add(haikei);
        haikei.setBounds(0,0,1400,800);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）

		//アイコンの設定
        rulebtn(slidehy);
        starter();
		
		
		
		
		
		

		//ボタンの生成
        mylogbtn = new JButton[15];
        youlogbtn = new JButton[15];
        janken = 0;
        yamacount = 0;
        mylog = -1;
        youlog = 0;
        kakumei = 0;
        taiketsu = 0;
        kouka = 0;
        choice1 = 0;
        choice5 = 0;
        sousa = 0;
        syugo = 0;
        tainum = 0;
        kenja = 0;
        ninefin = 0;
        kp = 0;
        
        int k=1;
        int p=0;
        for(int i=0; i <=8 ; i++){
            for(int j=1; j<3; j++){
                huda[p] = k;
                p++;
                }
            k++;
        }
        huda[17] = 10;
        
        
		//サーバに接続する
		Socket socket = null;
		try {
			//"localhost"は，自分内部への接続．localhostを接続先のIP Address（"133.42.155.201"形式）に設定すると他のPCのサーバと通信できる
			//10000はポート番号．IP Addressで接続するPCを決めて，ポート番号でそのPC上動作するプログラムを特定する
			socket = new Socket(IP, 10000);
		} catch (UnknownHostException e) {
			System.err.println("ホストの IP アドレスが判定できません: " + e);
		} catch (IOException e) {
			 System.err.println("エラーが発生しました: " + e);
		}
		
		MesgRecvThread mrt = new MesgRecvThread(socket, myName);//受信用のスレッドを作成する
		mrt.start();//スレッドを動かす（Runが動く）
	}
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        Line2D line = new Line2D.Double(1000, 0, 1000, 800);
        g2.draw(line);
    }
		
	//メッセージ受信のためのスレッド
	public class MesgRecvThread extends Thread{
		
		Socket socket;
		String myName;
		
		public MesgRecvThread(Socket s, String n){
			socket = s;
			myName = n;
		}
		
		//通信状況を監視し，受信データによって動作する
		public void run() {
			try{
				InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(sisr);
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println(myName);//接続の最初に名前を送る
                String myNumberStr = br.readLine();
                int myNumberInt = Integer.parseInt(myNumberStr);
                
                if(myNumberInt % 2 == 0){//それぞれに番号を割り当てる
                    myColor = 0;
                }else {
                    myColor = 1;
                }
                
                if(myColor == 0){
                    myTurn = 0;
                }else {
                    myTurn = 1;
                }
                
				while(true) {
					String inputLine = br.readLine();//データを一行分だけ読み込んでみる
					if (inputLine != null) {//読み込んだときにデータが読み込まれたかどうかをチェックする
						String[] inputTokens = inputLine.split(" ");	//入力データを解析するために、スペースで切り分ける
						String cmd = inputTokens[0];//コマンドの取り出し．１つ目の要素を取り出す
						if(cmd.equals("GU")){//cmdの文字と"GU"が同じか調べる．同じ時にtrueとなる
                            int theColor = Integer.parseInt(inputTokens[1]);
                            janken++;
                            guu++;
                            if(janken == 2){//じゃんけんによる先攻後攻の決定
                                if(tyo==1){
                                    if(theColor == myColor){
                                        myTurn = 0;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(senkou1);
                                    }else{
                                        myTurn = 1;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou);
                                    }
                                }else if(paa==1){
                                    if(theColor == myColor){
                                        myTurn = 1;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou);
                                    }else{
                                        myTurn = 0;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(senkou1);
                                    }
                                }else{
                                    if(theColor == myColor){
                                        sysbtn.setVisible(false);
                                        rulebtn(aikoa);
                                    }else if(theColor != myColor){
                                        sysbtn.setVisible(false);
                                        rulebtn(aikob);
                                    }
                                    janken=0;
                                    paa=0;
                                    guu=0;
                                    tyo=0;
                                }
                            }else{
                                myTurn = 1 - myTurn;
                            }
                        }else if(cmd.equals("TYO")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            janken++;
                            tyo++;
                            if(janken == 2){
                                if(paa==1){
                                    if(theColor == myColor){
                                        myTurn = 0;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(senkou1);
                                    }else{
                                        myTurn = 1;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou);
                                    }
                                }else if(guu==1){
                                    if(theColor == myColor){
                                        myTurn = 1;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou);
                                    }else{
                                        myTurn = 0;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(senkou1);
                                    }
                                }else{
                                    if(theColor == myColor){
                                        sysbtn.setVisible(false);
                                        rulebtn(aikob);
                                    }else if(theColor != myColor){
                                        sysbtn.setVisible(false);
                                        rulebtn(aikoa);
                                    }
                                    janken=0;
                                    paa=0;
                                    guu=0;
                                    tyo=0;
                                }
                            }else{
                                myTurn = 1 - myTurn;
                            }
                        }else if(cmd.equals("PA")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            janken++;
                            paa++;
                            if(janken == 2){
                                if(guu==1){
                                    if(theColor == myColor){
                                        myTurn = 0;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(senkou1);
                                    }else{
                                        myTurn = 1;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou);
                                    }
                                }else if(tyo==1){
                                    if(theColor == myColor){
                                        myTurn = 1;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou);
                                    }else{
                                        myTurn = 0;
                                        removebtn();
                                        sysbtn.setVisible(false);
                                        rulebtn(senkou1);
                                    }
                                }else{
                                    if(theColor == myColor){
                                        sysbtn.setVisible(false);
                                        rulebtn(aikob);
                                    }else if(theColor != myColor){
                                        sysbtn.setVisible(false);
                                        rulebtn(aikoa);
                                    }
                                    janken=0;
                                    paa=0;
                                    guu=0;
                                    tyo=0;
                                }
                            }else{
                                myTurn = 1 - myTurn;
                            }
                        }else if(cmd.equals("YAMAHUDA")){//山札からカードをを引く動作
                            yamacount++;
                            int theColor = Integer.parseInt(inputTokens[1]);
                            int knum = Integer.parseInt(inputTokens[2]);
                            int nokori = 0;
                            if(yamacount < 3){
                                if(theColor == myColor){
                                    mynum1 = huda[knum];
                                    myhuda(mynum1);
                                    nokori=0;
                                    if(yamacount == 1){
                                        sysbtn.setVisible(false);
                                        rulebtn(yamab);
                                    }else if(yamacount == 2){
                                        sysbtn.setVisible(false);
                                        rulebtn(yamab);
                                    }
                                }else {
                                    yournum1 = huda[knum];
                                    youhuda(yournum1);
                                    if(yamacount == 1){
                                        sysbtn.setVisible(false);
                                        rulebtn(koukou1);
                                    }else if(yamacount == 2){
                                        sysbtn.setVisible(false);
                                        rulebtn(yamaa);
                                    }
                                }
                                huda[knum] = 0;
                                myTurn = 1 - myTurn;
                            }else {
                                if(theColor == myColor){
                                    mynum2 = huda[knum];
                                    myhuda2(mynum2);
                                    nokori=0;
                                    mytehuda = 2;
                                }else { 
                                    yournum2 = huda[knum];
                                    youhuda2(yournum2);
                                }
                                huda[knum] = 0;
                            }
                        }else if(cmd.equals("KOUKA1,9")){//1と9のカードの効果
                            yamacount++;
                            choice1++;
                            int theColor = Integer.parseInt(inputTokens[1]);
                            int knum = Integer.parseInt(inputTokens[2]);
                            int nokori = 0;
                            if(theColor == myColor){
                                mynum2 = huda[knum];
                                myhuda2(mynum2);
                                mylog++;
                            }else {
                                yournum2 = huda[knum];
                                youhuda2(yournum2);
                                youhuda1.setVisible(false);
                                youhuda2.setVisible(false);
                                switch (yournum1){
                                    case 1:
                                        openyou = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou = new JButton(Icon110);
                                        break;
                                    }
                                haikei.add(openyou);
                                openyou.setBounds(450,20,100,160);
                                switch (yournum2){
                                    case 1:
                                        openyou2 = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou2 = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou2 = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou2 = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou2 = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou2 = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou2 = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou2 = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou2 = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou2 = new JButton(Icon110);
                                        break;
                                    }
                                haikei.add(openyou2);
                                openyou2.setBounds(330,20,100,160);
                            }
                            huda[knum] = 0;
                            myTurn = 1 - myTurn;
                        }else if (cmd.equals("1")){//1番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            kakumei++;
                            if(kakumei == 1){
                                sysbtn.setVisible(false);
                                if(inputTokens[2].equals("0")){
                                    if(theColor == myColor){
                                        kenja = 0;
                                        myhuda1.setVisible(false);
                                        myhuda2.setVisible(false);
                                        myzumi(mynum1,mylog);
                                        mynum1 = mynum2;
                                        myhuda(mynum2);
                                        sysbtn.setVisible(false);
                                        rulebtn(ka1a);
                                    }else if(theColor != myColor){
                                        youlog++;
                                        youhuda1.setVisible(false);
                                        youhuda2.setVisible(false);
                                        youzumi(yournum1,youlog);
                                        yournum1 = yournum2;
                                        youhuda(yournum2);
                                        sysbtn.setVisible(false);
                                        rulebtn(hi1a);
                                    }
                                }else if(inputTokens[2].equals("1")){
                                    if(theColor == myColor){
                                        kenja = 0;
                                        myhuda2.setVisible(false);
                                        myzumi(mynum2,mylog);
                                        sysbtn.setVisible(false);
                                        rulebtn(ka1a);
                                    }else if(theColor != myColor){
                                        youlog++;
                                        youhuda2.setVisible(false);
                                        youzumi(yournum2,youlog);
                                        sysbtn.setVisible(false);
                                        rulebtn(hi1a);
                                    }
                                }
                            }else if(kakumei == 2 && syugo != 1){
                                if(inputTokens[2].equals("0")){
                                    if(theColor == myColor){
                                        kenja = 0;
                                        myhuda1.setVisible(false);
                                        myhuda2.setVisible(false);
                                        myzumi(mynum1,mylog);
                                        mynum1 = mynum2;
                                        myhuda(mynum2);
                                        sysbtn.setVisible(false);
                                        rulebtn(ka1b);
                                    }else if(theColor != myColor){
                                        youlog++;
                                        youhuda1.setVisible(false);
                                        youhuda2.setVisible(false);
                                        youzumi(yournum1,youlog);
                                        yournum1 = yournum2;
                                        youhuda(yournum2);
                                        sysbtn.setVisible(false);
                                        rulebtn(hi1b);
                                    }
                                }else if(inputTokens[2].equals("1")){
                                    if(theColor == myColor){
                                        kenja = 0;
                                        myhuda2.setVisible(false);
                                        myzumi(mynum2,mylog);
                                        sysbtn.setVisible(false);
                                        rulebtn(ka1b);
                                    }else if(theColor != myColor){
                                        youlog++;
                                        youhuda2.setVisible(false);
                                        youzumi(yournum2,youlog);
                                        sysbtn.setVisible(false);
                                        rulebtn(hi1b);
                                    }
                                    
                                }
                                kouka++;
                            }else if(kakumei == 2 && syugo == 1){
                                if(inputTokens[2].equals("0")){
                                    if(theColor == myColor){
                                        kenja = 0;
                                        myhuda1.setVisible(false);
                                        myhuda2.setVisible(false);
                                        myzumi(mynum1,mylog);
                                        mynum1 = mynum2;
                                        myhuda(mynum2);
                                        sysbtn.setVisible(false);
                                        rulebtn(yamab);
                                    }else if(theColor != myColor){
                                        youlog++;
                                        youhuda1.setVisible(false);
                                        youhuda2.setVisible(false);
                                        youzumi(yournum1,youlog);
                                        yournum1 = yournum2;
                                        youhuda(yournum2);
                                        sysbtn.setVisible(false);
                                        rulebtn(yamaa);
                                    }
                                }else if(inputTokens[2].equals("1")){
                                    if(theColor == myColor){
                                        kenja = 0;
                                        myhuda2.setVisible(false);
                                        myzumi(mynum2,mylog);
                                        sysbtn.setVisible(false);
                                        rulebtn(yamab);
                                    }else if(theColor != myColor){
                                        youlog++;
                                        youhuda2.setVisible(false);
                                        youzumi(yournum2,youlog);
                                        sysbtn.setVisible(false);
                                        rulebtn(yamaa);
                                    }
                                }
                            }
                            syugo = 0;
                            myTurn = 1 - myTurn;
                            mytehuda = 1;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("2")){//２番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            mytehuda = 1;
                            if(syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                                myTurn = 1 - myTurn;
                            }else if(syugo == 0){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2);
                                }
                                kouka = 2;
                            }
                            syugo = 0;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("3")){//３番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor && syugo == 0){
                                sysbtn.setVisible(false);
                                rulebtn(ka3);
                                youhuda1.setVisible(false);
                                switch (yournum1){
                                    case 1:
                                        openyou = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou = new JButton(Icon110);
                                        break;
                                    }
                                haikei.add(openyou);
                                openyou.setBounds(450,20,100,160);
                                migi.setVisible(false);
                                kakunin();
                            }else if(theColor != myColor && syugo == 0){
                                sysbtn.setVisible(false);
                                rulebtn(hi3);
                            }
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            mytehuda = 1;
                            if(syugo == 0){
                                kouka = 3;
                            }else if(syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                                myTurn = 1 - myTurn;
                            }
                            syugo = 0;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("4")){//４番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(ka4);
                            }else if(theColor != myColor){
                                sysbtn.setVisible(false);
                                rulebtn(hi4);
                            }
                            syugo = 1;
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("5")){//５番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            if(syugo == 0){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka5);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi5);
                                }
                                kouka = 5;
                                myTurn = 1 - myTurn;
                            }else if(syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                                myTurn = 1 - myTurn;
                            }
                            syugo = 0;
                            mytehuda = 1;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("6")){//６番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            taiketsu++;
                            tainum = 2;
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            if(taiketsu == 1 && syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                                mytehuda = 1;
                                myTurn = 1 - myTurn;
                            }else if(taiketsu == 1 && syugo == 0){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka6a);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi6b);
                                }
                                if(theColor == myColor){
                                    kouka = 6;
                                    youhuda1.setVisible(false);
                                    switch (yournum1){
                                    case 1:
                                        openyou = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou = new JButton(Icon110);
                                        break;
                                    }
                                    haikei.add(openyou);
                                    openyou.setBounds(450,20,100,160);
                                    migi.setVisible(false);
                                    kakunin();
                                    myTurn = 1 - myTurn;
                                }else if(theColor != myColor){
                                    kouka = 6;
                                    youhuda1.setVisible(false);
                                    switch (yournum1){
                                    case 1:
                                        openyou = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou = new JButton(Icon110);
                                        break;
                                    }
                                    haikei.add(openyou);
                                    openyou.setBounds(450,20,100,160);
                                    migi.setVisible(false);
                                    kakunin();
                                    myTurn = 1 - myTurn;
                                }
                            }else if(taiketsu == 2 && syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                                mytehuda = 1;
                                myTurn = 1 - myTurn;
                            }else if(taiketsu == 2 && syugo == 0){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka6b);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi6b);
                                }
                                if(mynum1 == yournum1){
                                    mytehuda = 1;
                                    myTurn = 1 - myTurn;
                                }else{
                                    msg = "FINISH";
                                    out.println(msg);
                                    out.flush();
                                }
                            }
                            syugo = 0;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("7")){//７番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 1;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 1;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(ka7);
                            }else if(theColor != myColor){
                                sysbtn.setVisible(false);
                                rulebtn(hi7);
                            }
                            syugo = 0;
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("8")){//８番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }if(syugo == 0){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka8);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi8);
                                }
                                if(theColor == myColor){
                                    myhuda1.setVisible(false);
                                    youhuda1.setVisible(false);
                                    int n = yournum1;
                                    yournum1 = mynum1;
                                    mynum1 = n;
                                    myhuda(mynum1);
                                    youhuda(yournum1);
                                }else if(theColor != myColor){
                                    youhuda1.setVisible(false);
                                    myhuda1.setVisible(false);
                                    int n = yournum1;
                                    yournum1 = mynum1;
                                    mynum1 = n;
                                    myhuda(mynum1);
                                    youhuda(yournum1);
                                }
                            }else if(syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                            }
                            syugo = 0;
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("9")){//９番を使用
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(inputTokens[2].equals("0")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda1.setVisible(false);
                                    myhuda2.setVisible(false);
                                    myzumi(mynum1,mylog);
                                    mynum1 = mynum2;
                                    myhuda(mynum2);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                    youzumi(yournum1,youlog);
                                    yournum1 = yournum2;
                                    youhuda(yournum2);
                                }
                            }else if(inputTokens[2].equals("1")){
                                if(theColor == myColor){
                                    kenja = 0;
                                    myhuda2.setVisible(false);
                                    myzumi(mynum2,mylog);
                                }else if(theColor != myColor){
                                    youlog++;
                                    youhuda2.setVisible(false);
                                    youzumi(yournum2,youlog);
                                }
                            }
                            if(syugo == 0){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka9);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi9);
                                }
                                kouka = 9;
                            }else if(syugo == 1){
                                if(theColor == myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamab);
                                }else if(theColor != myColor){
                                    sysbtn.setVisible(false);
                                    rulebtn(yamaa);
                                }
                            }
                            syugo = 0;
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if (cmd.equals("10")){//１０番は使用できない
                            int theColor = Integer.parseInt(inputTokens[1]);
                        }else if(cmd.equals("HIDARI")){//左ボタンを選択
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(kouka == 9){
                                if(theColor != myColor){
                                    if(mynum2 == 10){
                                        ninefin = 1;
                                    }
                                }
                                if(ninefin == 1){
                                    msg = "NINEFINISH";
                                    out.println(msg);
                                    out.flush();
                                }
                            }
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(yamab);
                            }else if(theColor != myColor){
                                sysbtn.setVisible(false);
                                rulebtn(yamaa);
                            }
                            if(theColor != myColor){
                                myhuda1.setVisible(false);
                                myhuda2.setVisible(false);
                                myzumi(mynum2,mylog);
                                myhuda(mynum1);
                                youhuda(yournum1);
                            }else{
                                youlog++;
                                if(kouka == 1 || kouka == 9){
                                    openyou.setVisible(false);
                                    openyou2.setVisible(false);
                                }else if(kouka == 5){
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                }
                                youzumi(yournum2,youlog);
                                youhuda(yournum1);
                            }
                            choice1 = 0;
                            choice5 = 0;
                            kouka = 0;
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if(cmd.equals("MIGI")){//右ボタンを選択
                            choice1 = 0;
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(kouka == 9){
                                if(theColor != myColor){
                                    if(mynum1 == 10){
                                        ninefin = 1;
                                    }
                                }
                                if(ninefin == 1){
                                    msg = "NINEFINISH";
                                    out.println(msg);
                                    out.flush();
                                }
                            }
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(yamab);
                            }else if(theColor != myColor){
                                sysbtn.setVisible(false);
                                rulebtn(yamaa);
                            }
                            if(theColor != myColor){
                                myhuda1.setVisible(false);
                                myhuda2.setVisible(false);
                                myzumi(mynum1,mylog);
                                mynum1 = mynum2;
                                myhuda(mynum2);
                            }else{
                                youlog++;
                                if(kouka == 1 ||  kouka == 9){
                                    openyou.setVisible(false);
                                    openyou2.setVisible(false);
                                }else if(kouka == 5){
                                    youhuda1.setVisible(false);
                                    youhuda2.setVisible(false);
                                }
                                youzumi(yournum1,youlog);
                                yournum1 = yournum2;
                                youhuda(yournum2);
                            }
                            kouka = 0;
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                            if(judge()){
                                msg = "FINISH";
                                out.println(msg);
                                out.flush();
                            }
                        }else if(cmd.equals("1BAN")){//2の効果1~10選択
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 1){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 1){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 1){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("2BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 2){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 2){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 2){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("3BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 3){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 3){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 3){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("4BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 4){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 4){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 4){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("5BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 5){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 5){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 5){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("6BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 6){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 6){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 6){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("7BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 7){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 7){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 7){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("8BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 8){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 8){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 8){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("9BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 9){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 9){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 9){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("10BAN")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                if(yournum1 == 10){
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2suc);
                                    msg = "FINISH2";
                                    out.println(msg);
                                    out.flush();
                                }else{
                                    sysbtn.setVisible(false);
                                    rulebtn(ka2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }
                            }else if(theColor != myColor){
                                if(mynum1 != 10){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2fai);
                                    sousa = 0;
                                    kouka = 0;
                                    mytehuda = 1;
                                    myTurn = 1- myTurn;
                                }else if(mynum1 == 10){
                                    sysbtn.setVisible(false);
                                    rulebtn(hi2suc);
                                }
                            }
                        }else if(cmd.equals("3OK")){//OKボタンの選択
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(yamab);
                            }else if(theColor != myColor){
                                sysbtn.setVisible(false);
                                rulebtn(yamaa);
                            }
                            if(theColor == myColor){
                                okbtn.setVisible(false);
                                migibtn();
                                openyou.setVisible(false);
                                youhuda(yournum1);
                            }
                            kouka = 0;
                            mytehuda = 1;
                            myTurn = 1- myTurn;
                        }else if(cmd.equals("KOUKA5")){//5の効果を発動
                            yamacount++;
                            choice5++;
                            int theColor = Integer.parseInt(inputTokens[1]);
                            int knum = Integer.parseInt(inputTokens[2]);
                            int lnum = Integer.parseInt(inputTokens[3]);
                            if(theColor == myColor){
                                mynum2 = huda[knum];
                                if(lnum == 0){
                                    myhuda2(mynum2);
                                }else if(lnum == 1){
                                    int a = mynum2;
                                    mynum2 = mynum1;
                                    mynum1 = a;
                                    myhuda1.setVisible(false);
                                    myhuda(mynum1);
                                    myhuda2(mynum2);
                                }
                                mylog++;
                            }else {
                                if(lnum == 0){
                                    yournum2 = huda[knum];
                                    youhuda2(yournum2);
                                }else if(lnum == 1){
                                    int a = yournum2;
                                    yournum2 = yournum1;
                                    yournum1 = a;
                                    youhuda(yournum1);
                                    youhuda2(yournum2);
                                }
                            }
                            huda[knum] = 0;
                            myTurn = 1 - myTurn;
                        }else if(cmd.equals("KOUKA7")){//7の効果を発動
                            yamacount++;
                            int theColor = Integer.parseInt(inputTokens[1]);
                            ken1 = Integer.parseInt(inputTokens[2]);
                            ken2 = Integer.parseInt(inputTokens[3]);
                            ken3 = Integer.parseInt(inputTokens[4]);
                            if(theColor == myColor){
                                sentaku1(huda[ken1]);
                                if(huda[ken2]!=0){
                                    sentaku2(huda[ken2]);
                                }
                                if(huda[ken3]!=0){
                                    sentaku3(huda[ken3]);
                                }
                            }
                            kouka = 7;
                            mytehuda = 2;
                        }else if(cmd.equals("KEN1")){//7の効果により、三枚のうちから一枚を選択できる
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(sentaku7);
                                ken1btn.setVisible(false);
                                ken2btn.setVisible(false);
                                ken3btn.setVisible(false);
                                mynum2 = huda[ken1];
                                myhuda2(mynum2);
                                mytehuda = 2;
                            }else { 
                                yournum2 = huda[ken1];
                                youhuda2(yournum2);
                            }
                            huda[ken1] = 0;
                            kouka = 0;
                            mytehuda = 2;
                        }else if(cmd.equals("KEN2")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(sentaku7);
                                ken1btn.setVisible(false);
                                ken2btn.setVisible(false);
                                ken3btn.setVisible(false);
                                mynum2 = huda[ken2];
                                myhuda2(mynum2);
                                mytehuda = 2;
                            }else { 
                                yournum2 = huda[ken2];
                                youhuda2(yournum2);
                            }
                            huda[ken2] = 0;
                            kouka = 0;
                            mytehuda = 2;
                        }else if(cmd.equals("KEN3")){
                            int theColor = Integer.parseInt(inputTokens[1]);
                            if(theColor == myColor){
                                sysbtn.setVisible(false);
                                rulebtn(sentaku7);
                                ken1btn.setVisible(false);
                                ken2btn.setVisible(false);
                                ken3btn.setVisible(false);
                                mynum2 = huda[ken3];
                                myhuda2(mynum2);
                                mytehuda = 2;
                            }else { 
                                yournum2 = huda[ken3];
                                youhuda2(yournum2);
                            }
                            huda[ken3] = 0;
                            kouka = 0;
                            mytehuda = 2;
                        }else if(cmd.equals("FINISH")){//終了判定
                            youhuda1.setVisible(false);
                            switch (yournum1){
                                    case 1:
                                        openyou = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou = new JButton(Icon110);
                                        break;
                                    }
                            haikei.add(openyou);
                            openyou.setBounds(450,20,100,160);
                            fin = 1;
                            if(mynum1 < yournum1){
                                loser();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(losea);
                            }else if(mynum1 > yournum1){
                                winner();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(wina);
                            }else if(mynum1 == yournum1){
                                drower();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(drowa);
                            }
                        }else if(cmd.equals("FINISH2")){
                            if(sousa == 1){ 
                                winner();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(wina);
                            }else if(sousa == 0){
                                loser();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(losea);
                            }
                            youhuda1.setVisible(false);
                            switch (yournum1){
                                    case 1:
                                        openyou = new JButton(Icon01);
                                        break;
                                    case 2:
                                        openyou = new JButton(Icon02);
                                        break;
                                    case 3:
                                        openyou = new JButton(Icon03);
                                        break;
                                    case 4:
                                        openyou = new JButton(Icon04);
                                        break;
                                    case 5:
                                        openyou = new JButton(Icon05);
                                        break;
                                    case 6:
                                        openyou = new JButton(Icon06);
                                        break;
                                    case 7:
                                        openyou = new JButton(Icon07);
                                        break;
                                    case 8:
                                        openyou = new JButton(Icon08);
                                        break;
                                    case 9:
                                        openyou = new JButton(Icon09);
                                        break;
                                    case 10:
                                        openyou = new JButton(Icon110);
                                        break;
                                    }
                            haikei.add(openyou);
                            openyou.setBounds(450,20,100,160);
                            fin = 1;
                        }else if(cmd.equals("NINEFINISH")){
                            if(ninefin == 1){
                                loser();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(losea);
                            }else if(ninefin != 1){
                                winner();
                                yamahuda.setBorderPainted(false);
                                sysbtn.setVisible(false);
                                rulebtn(wina);
                            }
                            fin = 1;
                        }else if(cmd.equals("OPEN")){//互いの手札を開示
                            int theColor = Integer.parseInt(inputTokens[1]);
                            tainum--;
                            if(theColor == myColor){
                                okbtn.setVisible(false);
                                migibtn();
                                openyou.setVisible(false);
                                youhuda(yournum1);
                            }
                            if(tainum == 0){
                                kouka = 0;
                            }
                            mytehuda = 1;
                            myTurn = 1 - myTurn;
                        }
					}else{
						break;
					}
				
				}
				socket.close();
			} catch (IOException e) {//エラー処理
				System.err.println("エラーが発生しました: " + e);
			}
		}
	}


    public void painta(Graphics g){//枠線の追加
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        Line2D line = new Line2D.Double(1000, 0, 1000, 800);
        g2.draw(line);
    }


	public static void main(String[] args) {
		MyClient2 net = new MyClient2();
		net.setVisible(true);
	}
  	
	public void mouseClicked(MouseEvent e) {//ボタンをクリックしたときの処理
		JButton theButton = (JButton)e.getComponent();//クリックしたオブジェクトを得る．型が違うのでキャストする
		String theArrayIndex = theButton.getActionCommand();//ボタンの配列の番号を取り出す

		Icon theIcon = theButton.getIcon();//theIconには，現在のボタンに設定されたアイコンが入る

        if(theButton == startbtn){//スタートを選択
            sysbtn.setVisible(false);
            if(myTurn==0){
                rulebtn(slidesen);
            }else if(myTurn == 1){
                rulebtn(slidekou);
            }
            start();
        }

        if(theButton == winbutton){//勝利ボタン選択
            winbutton.setVisible(false);
        }
        if(theButton == drowbutton){//ドローボタン選択
            drowbutton.setVisible(false);
        }
        if(theButton == losebutton){//敗北ボタン選択
            losebutton.setVisible(false);
        }

        if(myTurn==0){
            if(theButton == gu){//じゃんけんボタンが押された時の反応
                msg = "GU"+" "+myColor;
                out.println(msg);
                out.flush();
            }else if(theButton == pa){
                msg = "PA"+" "+myColor;
                out.println(msg);
                out.flush();
            }else if(theButton == tyoki){
                msg = "TYO"+" "+myColor;
                out.println(msg);
                out.flush();
            }else if(theButton == yamahuda && mytehuda != 2 && fin != 1 && choice1 == 0 && kouka != 2 && kouka != 3 && choice5 == 0 &&  kouka != 6 && tainum == 0){
                if(kenja == 0){//山札が選択された時の処理
                    Random r = new Random();
                    int Rnum = r.nextInt(18);
                    while(huda[Rnum]==0){
                        Rnum = r.nextInt(18);
                    }
                    if(kouka == 0){
                        mylog++;
                        msg = "YAMAHUDA"+" "+myColor+" "+Rnum;
                    }else if (kouka == 1){
                        mytehuda = 2;
                        msg = "KOUKA1,9"+" "+myColor+" "+Rnum;
                    }else if(kouka == 9){
                        mytehuda = 2;
                        msg = "KOUKA1,9"+" "+myColor+" "+Rnum;
                    }else if(kouka == 5){
                        mytehuda = 2;
                        Random p = new Random();
                        int Pnum = p.nextInt(2);
                        msg = "KOUKA5"+" "+myColor+" "+Rnum+" "+Pnum;
                    }
                    out.println(msg);
                    out.flush();
                }else if(kenja == 1 && kouka != 5 && kouka != 9 && kouka != 1){
                    sevenfin = 0;
                    for(int i = 0; i<3;i++){
                        for(int j=0;j<18;j++){
                            if(huda[j]==0){
                                sevenfin++;
                            }
                        }
                        if(sevenfin != 18){
                            Random r = new Random();
                                kennum[i] = r.nextInt(18);
                            while(huda[kennum[i]]==0){
                                kennum[i] = r.nextInt(18);
                            }
                        }else if(sevenfin == 18){
                            kennum[i]=0;
                        }
                        sevenfin = 0;
                    }
                    mylog++;
                    msg = "KOUKA7"+" "+myColor+" "+kennum[0]+" "+kennum[1]+" "+kennum[2];
                    out.println(msg);
                    out.flush();
                }
            }else if(mytehuda == 2 && kouka == 0){
                if(theButton == myhuda1){//手札のカードを使用
                    switch (mynum1){
                        case 1:
                            msg = "1"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 2:
                            msg = "2"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 3:
                            msg = "3"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 4:
                            msg = "4"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 5:
                            msg = "5"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 6:
                            msg = "6"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 7:
                            msg = "7"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 8:
                            msg = "8"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 9:
                            msg = "9"+" "+myColor+" "+"0";
                            out.println(msg);
                            out.flush();
                            break;
                        case 10:
                            break;
                    }
                }else if(theButton == myhuda2){
                    switch (mynum2){
                        case 1:
                            msg = "1"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 2:
                            msg = "2"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 3:
                            msg = "3"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 4:
                            msg = "4"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 5:
                            msg = "5"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 6:
                            msg = "6"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 7:
                            msg = "7"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 8:
                            msg = "8"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 9:
                            msg = "9"+" "+myColor+" "+"1";
                            out.println(msg);
                            out.flush();
                            break;
                        case 10:
                    }
                }
            }else if(kouka == 1 && choice1 == 1){
                if(theButton == hidari){//左のボタンを選択
                    msg = "HIDARI"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton == migi){
                    msg = "MIGI"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else {
                }
            }else if(kouka == 9 && choice1 == 1){
                if(theButton == hidari){//右のボタンを選択
                    msg = "HIDARI"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton == migi){
                    msg = "MIGI"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else {
                }
            }else if(kouka == 5 && choice5 == 1){
                if(theButton == hidari){
                    msg = "HIDARI"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton == migi){
                    msg = "MIGI"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else {
                }
            }else if(kouka == 2){//二番の効果で相手の手札を当てる
                sousa = 1;
                if(theButton==ban1){
                    msg = "1BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban2){
                    msg = "2BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban3){
                    msg = "3BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban4){
                    msg = "4BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban5){
                    msg = "5BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban6){
                    msg = "6BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban7){
                    msg = "7BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban8){
                    msg = "8BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban9){
                    msg = "9BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else if(theButton==ban10){
                    msg = "10BAN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else{
                }
            }else if(kouka == 3){//三番「透視」の効果
                if(theButton == okbtn){
                    msg = "3OK"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else {
                }
            }else if(kouka == 7 && mytehuda == 2){//7番の効果
                if(theButton == ken1btn){
                    msg = "KEN1"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }
                if(theButton == ken2btn){
                    msg = "KEN2"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }
                if(theButton == ken3btn){
                    msg = "KEN3"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else {
                }
            }else if(kouka == 6){//6番の効果
                if(theButton == okbtn){
                    msg = "OPEN"+" "+myColor;
                    out.println(msg);
                    out.flush();
                }else{
                }
            }
        }else if(myTurn == 1){
        }
    }
    
    public void start(){//スタートを押したときの処理
        startbtn.setVisible(false);
        xenobtn.setVisible(false);
        
        gu = new JButton(guIcon);//じゃんけんのボタン
        haikei.add(gu);//ペインに貼り付ける
        gu.setBounds(650,300,100,100);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
        gu.addMouseListener(this);//ボタンをマウスでさわったときに反応するようにする
        //buttonArray[j][i].setActionCommand(Integer.toString(j * 8 + i));ボタンに配列の情報を付加する（ネットワークを介してオブジェクトを識別するため）
        
        tyoki = new JButton(choIcon);//じゃんけんのボタン
        haikei.add(tyoki);
        tyoki.setBounds(450,300,100,100);
        tyoki.addMouseListener(this);
        
        pa = new JButton(paIcon);//じゃんけんのボタン
        haikei.add(pa);
        pa.setBounds(250,300,100,100);
        pa.addMouseListener(this);
    }
    
    public void removebtn(){//じゃんけん終了時の処理
        pa.setVisible(false);
        gu.setVisible(false);
        tyoki.setVisible(false);
        yamahuda = new JButton(haIcon);
        haikei.add(yamahuda);
        yamahuda.setBounds(450,320,100,160);
        yamahuda.addMouseListener(this);
        
        ban1 = new JButton(Icon1);//様々な場面で使用する番号ボタンの配置
        haikei.add(ban1);
        ban1.setBounds(1065,320,90,90);
        ban1.addMouseListener(this);
        
        ban2 = new JButton(Icon2);
        haikei.add(ban2);
        ban2.setBounds(1155,320,90,90);
        ban2.addMouseListener(this);
        
        ban3 = new JButton(Icon3);
        haikei.add(ban3);
        ban3.setBounds(1245,320,90,90);
        ban3.addMouseListener(this);
        
        ban4 = new JButton(Icon4);
        haikei.add(ban4);
        ban4.setBounds(1065,410,90,90);
        ban4.addMouseListener(this);
        
        ban5 = new JButton(Icon5);
        haikei.add(ban5);
        ban5.setBounds(1155,410,90,90);
        ban5.addMouseListener(this);
        
        ban6 = new JButton(Icon6);
        haikei.add(ban6);
        ban6.setBounds(1245,410,90,90);
        ban6.addMouseListener(this);
        
        ban7 = new JButton(Icon7);
        haikei.add(ban7);
        ban7.setBounds(1065,500,90,90);
        ban7.addMouseListener(this);
        
        ban8 = new JButton(Icon8);
        haikei.add(ban8);
        ban8.setBounds(1155,500,90,90);
        ban8.addMouseListener(this);
        
        ban9 = new JButton(Icon9);
        haikei.add(ban9);
        ban9.setBounds(1245,500,90,90);
        ban9.addMouseListener(this);
        
        hidari = new JButton(LIcon);
        haikei.add(hidari);
        hidari.setBounds(1065,590,90,90);
        hidari.addMouseListener(this);
        
        ban10 = new JButton(Icon10);
        haikei.add(ban10);
        ban10.setBounds(1155,590,90,90);
        ban10.addMouseListener(this);
        
        migi = new JButton(RIcon);
        haikei.add(migi);
        migi.setBounds(1245,590,90,90);
        migi.addMouseListener(this);
    }
    
    public void myhuda(int x){//自分の手札の表示
        switch (x){
            case 1:
                myhuda1 = new JButton(Icon01);
                break;
            case 2:
                myhuda1 = new JButton(Icon02);
                break;
            case 3:
                myhuda1 = new JButton(Icon03);
                break;
            case 4:
                myhuda1 = new JButton(Icon04);
                break;
            case 5:
                myhuda1 = new JButton(Icon05);
                break;
            case 6:
                myhuda1 = new JButton(Icon06);
                break;
            case 7:
                myhuda1 = new JButton(Icon07);
                break;
            case 8:
                myhuda1 = new JButton(Icon08);
                break;
            case 9:
                myhuda1 = new JButton(Icon09);
                break;
            case 10:
                myhuda1 = new JButton(Icon110);
                break;
        }
        haikei.add(myhuda1);
        myhuda1.setBounds(450,580,100,160);
        myhuda1.addMouseListener(this);
        myhuda1.setBorderPainted(false);
    }
    
    public void youhuda(int x){//相手の手札の表示
        int youhudaA = x;
        youhuda1 = new JButton(haIcon);
        haikei.add(youhuda1);
        youhuda1.setBounds(450,20,100,160);
        youhuda1.addMouseListener(this);
    }
    
    public void myhuda2(int x){//自分の手札の二枚目の表示
        switch (x){
            case 1:
                myhuda2 = new JButton(Icon01);
                break;
            case 2:
                myhuda2 = new JButton(Icon02);
                break;
            case 3:
                myhuda2 = new JButton(Icon03);
                break;
            case 4:
                myhuda2 = new JButton(Icon04);
                break;
            case 5:
                myhuda2 = new JButton(Icon05);
                break;
            case 6:
                myhuda2 = new JButton(Icon06);
                break;
            case 7:
                myhuda2 = new JButton(Icon07);
                break;
            case 8:
                myhuda2 = new JButton(Icon08);
                break;
            case 9:
                myhuda2 = new JButton(Icon09);
                break;
            case 10:
                myhuda2 = new JButton(Icon110);
                break;
        }
        haikei.add(myhuda2);
        myhuda2.setBounds(570,580,100,160);
        myhuda2.addMouseListener(this);
        myhuda2.setBorderPainted(false);
    }
    
    public void youhuda2(int x){//相手の手札の二枚目の表示
        int youhudaA = x;
        youhuda2 = new JButton(haIcon);
        haikei.add(youhuda2);
        youhuda2.setBounds(330,20,100,160);
        youhuda2.addMouseListener(this);
    }
    
    public void myzumi(int x, int y){//自分の使用済みの手札の表示
        switch (x){
            case 1:
                mylogbtn[y] = new JButton(Icon01);
                break;
            case 2:
                mylogbtn[y] = new JButton(Icon02);
                break;
            case 3:
                mylogbtn[y] = new JButton(Icon03);
                break;
            case 4:
                mylogbtn[y] = new JButton(Icon04);
                break;
            case 5:
                mylogbtn[y] = new JButton(Icon05);
                break;
            case 6:
                mylogbtn[y] = new JButton(Icon06);
                break;
            case 7:
                mylogbtn[y] = new JButton(Icon07);
                break;
            case 8:
                mylogbtn[y] = new JButton(Icon08);
                break;
            case 9:
                mylogbtn[y] = new JButton(Icon09);
                break;
            case 10:
                mylogbtn[y] = new JButton(Icon110);
                break;
        }
        c.add(mylogbtn[y]);
        mylogbtn[y].setBounds(50+30*(y-1),580,100,160);
        c.setLayer(mylogbtn[y],5+y);
    }
    
    public void youzumi(int x, int y){//相手の使用済み手札の表示
        switch (x){
            case 1:
                youlogbtn[y] = new JButton(Icon01);
                break;
            case 2:
                youlogbtn[y] = new JButton(Icon02);
                break;
            case 3:
                youlogbtn[y] = new JButton(Icon03);
                break;
            case 4:
                youlogbtn[y] = new JButton(Icon04);
                break;
            case 5:
                youlogbtn[y] = new JButton(Icon05);
                break;
            case 6:
                youlogbtn[y] = new JButton(Icon06);
                break;
            case 7:
                youlogbtn[y] = new JButton(Icon07);
                break;
            case 8:
                youlogbtn[y] = new JButton(Icon08);
                break;
            case 9:
                youlogbtn[y] = new JButton(Icon09);
                break;
            case 10:
                youlogbtn[y] = new JButton(Icon110);
                break;
        }
        c.add(youlogbtn[y]);
        youlogbtn[y].setBounds(600+30*(y-1),20,100,160);
        c.setLayer(youlogbtn[y],5+y);
    }
    
    public void rulebtn(ImageIcon x){//右上の解説ボタンの表示
        sysbtn = new JButton(x);
        haikei.add(sysbtn);
        sysbtn.setBounds(998,0,400,300);
    }
    
    public boolean judge(){//終了判定
        boolean flag = false;
        for(int i=0;i<18;i++){
            if(huda[i]==0){
                fincount++;
            }
        }
        if(fincount == 18){
            flag = true;
        }
        fincount=0;
        return flag;
    }
    
    public void kakunin(){//確認ボタンの表示
        okbtn = new JButton(okIcon);
        haikei.add(okbtn);
        okbtn.setBounds(1245,590,90,90);
        okbtn.addMouseListener(this);
    }
    
    public void migibtn(){//右ボタンの表示
        migi = new JButton(RIcon);
        haikei.add(migi);
        migi.setBounds(1245,590,90,90);
        migi.addMouseListener(this);
    }
    
    public void sentaku1(int x){//7の効果による札の表示
        switch (x){
            case 1:
                ken1btn = new JButton(Icon01);
                break;
            case 2:
                ken1btn = new JButton(Icon02);
                break;
            case 3:
                ken1btn = new JButton(Icon03);
                break;
            case 4:
                ken1btn = new JButton(Icon04);
                break;
            case 5:
                ken1btn = new JButton(Icon05);
                break;
            case 6:
                ken1btn = new JButton(Icon06);
                break;
            case 7:
                ken1btn = new JButton(Icon07);
                break;
            case 8:
                ken1btn = new JButton(Icon08);
                break;
            case 9:
                ken1btn = new JButton(Icon09);
                break;
            case 10:
                ken1btn = new JButton(Icon110);
                break;
        }
        haikei.add(ken1btn);
        ken1btn.setBounds(605,580,100,160);
        ken1btn.addMouseListener(this);
    }
    public void sentaku2(int x){
        switch (x){
            case 1:
                ken2btn = new JButton(Icon01);
                break;
            case 2:
                ken2btn = new JButton(Icon02);
                break;
            case 3:
                ken2btn = new JButton(Icon03);
                break;
            case 4:
                ken2btn = new JButton(Icon04);
                break;
            case 5:
                ken2btn = new JButton(Icon05);
                break;
            case 6:
                ken2btn = new JButton(Icon06);
                break;
            case 7:
                ken2btn = new JButton(Icon07);
                break;
            case 8:
                ken2btn = new JButton(Icon08);
                break;
            case 9:
                ken2btn = new JButton(Icon09);
                break;
            case 10:
                ken2btn = new JButton(Icon110);
                break;
        }
        haikei.add(ken2btn);
        ken2btn.setBounds(725,580,100,160);
        ken2btn.addMouseListener(this);
    }
    public void sentaku3(int x){
        switch (x){
            case 1:
                ken3btn = new JButton(Icon01);
                break;
            case 2:
                ken3btn = new JButton(Icon02);
                break;
            case 3:
                ken3btn = new JButton(Icon03);
                break;
            case 4:
                ken3btn = new JButton(Icon04);
                break;
            case 5:
                ken3btn = new JButton(Icon05);
                break;
            case 6:
                ken3btn = new JButton(Icon06);
                break;
            case 7:
                ken3btn = new JButton(Icon07);
                break;
            case 8:
                ken3btn = new JButton(Icon08);
                break;
            case 9:
                ken3btn = new JButton(Icon09);
                break;
            case 10:
                ken3btn = new JButton(Icon110);
                break;
        }
        haikei.add(ken3btn);
        ken3btn.setBounds(845,580,100,160);
        ken3btn.addMouseListener(this);
    }
    
    public void starter(){//スタート画面の表示
        xenobtn = new JButton(xenoIcon);
        haikei.add(xenobtn);
        xenobtn.setBounds(275,205,450,145);
        startbtn = new JButton(startIcon);//スタートボタン
        haikei.add(startbtn);
        startbtn.setBounds(300,440,400,200);
        startbtn.addMouseListener(this);
    }
    
    public void winner(){
        winbutton = new JButton(win);//勝利ボタン
        c.add(winbutton);
        winbutton.setBounds(200,230,600,355);
        winbutton.addMouseListener(this);
        c.setLayer(winbutton,500);
    }
    
    public void loser(){//敗北ボタン
        losebutton = new JButton(lose);
        c.add(losebutton);
        losebutton.setBounds(200,230,600,355);
        losebutton.addMouseListener(this);
        c.setLayer(losebutton,500);
    }
    
    public void drower(){//ドローボタン
        drowbutton = new JButton(drow);
        c.add(drowbutton);
        drowbutton.setBounds(200,230,600,355);
        drowbutton.addMouseListener(this);
        c.setLayer(drowbutton,500);
    }
    
    public void mouseExited(MouseEvent e) {//書いていないと動作しないマウスの動きに応じた処理
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
	}
    public void mouseReleased(MouseEvent e) {
	}
    public void mouseMoved(MouseEvent e) {
	}
    public void mouseDragged(MouseEvent e) {
    }
}