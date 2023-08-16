/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskagıtmakas;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;



/**
 *
 * @author NizamVY
 */
public class TasKagıtMakas extends Application {

    public static ImageView imgTas;
    public static ImageView imgKagıt;
    public static ImageView imgMakas;
    public static ImageView pcTas;
    public static ImageView pcKagıt;
    public static ImageView pcMakas;
    public static ImageView imgKazandi;
    public static ImageView imgKaybetti;
    public static ImageView imgBerabere;

    
    GridPane gp2;
    Scene sceneSkor;
    public static TextField txt;
    StackPane spOrta;
    BorderPane bp;
    
    Scene scene;
    double sceneWidth = 900;
    double sceneHeight = 800;
    public static String secim;
    Stage anaPencere;
    
    public Label label = new Label("Sonuç!");
    int sonuc;
    
    public static int kSecim;
    public static int bSecim;
    public StackPane spKazandi;
    public StackPane spBeraberlik;
    public StackPane spKaybetti;
    
    @Override
    public void start(Stage primaryStage) {
    // bu metod dışından da erişilebilir olması gerekiyor
    anaPencere = primaryStage;
    
    // resimlerin yüklenmesi
        imgTas = new ImageView(new Image("file:images/t.png"));
        imgKagıt = new ImageView(new Image("file:images/kagit.png"));
        imgMakas = new ImageView(new Image("file:images/makas.png"));
        
        imgBerabere=new ImageView(new Image("file:images/beraberlik.png"));
        imgKazandi=new ImageView(new Image("file:images/kazandi.png"));
        imgKaybetti=new ImageView(new Image("file:images/kaybetti.png"));
        
        label.setTranslateX(sceneWidth / 2 - 95);
        label.setTranslateY(sceneHeight / 2 - 300);
        label.setStyle("-fx-font-family: Tahoma; -fx-font-weight: bold; -fx-font-size: 50px; -fx-text-fill: NAVY");
        label.setVisible(false);
        
        pcTas = new ImageView(new Image("file:images/pcTas.png"));
        pcKagıt = new ImageView(new Image("file:images/pcKagit.png"));
        pcMakas = new ImageView(new Image("file:images/pcMakas.png"));
        

        // Program başladığında ilk gözüken arayüzün ayarları (gp1)
        GridPane gp1 = new GridPane();
        gp1.setAlignment(Pos.CENTER);
        gp1.setPadding(new Insets(10, 10, 10, 10));
        gp1.setHgap(10);
        gp1.setVgap(10);
        gp1.add(new Label("Seçiminiz:"), 0, 0);
        txt = new TextField();
        txt.setText("taş");
        gp1.add(txt, 1, 0);
        Button btnBasla = new Button("   Seçimi Tamamla!   ");
        btnBasla.setStyle("-fx-font-weight: bold");
        gp1.add(btnBasla, 1, 3);
        GridPane.setHalignment(btnBasla, HPos.RIGHT);

        Scene login = new Scene(gp1, 350, 150);
        anaPencere.setTitle("Taş Kağıt Makas | Oyun Kayıt");
        anaPencere.setScene(login);
        anaPencere.show();

        // İsim girme alanının hazır hale getirilmesi
        txt.requestFocus();

        // Skor listesini gösteren arayüzle ilgili ayarlar
        gp2 = new GridPane();
        gp2.setAlignment(Pos.CENTER);
        gp2.setPadding(new Insets(10, 10, 10, 10));
        gp2.setHgap(60);
        gp2.setVgap(20);

        spOrta = new StackPane();
        spOrta.setAlignment(Pos.TOP_LEFT);
        
        StackPane spTas = new StackPane(imgTas, spOrta);
        spTas.setAlignment(Pos.BASELINE_LEFT);
        StackPane spKagit = new StackPane(imgKagıt, spOrta);
        spKagit.setAlignment(Pos.BASELINE_LEFT);
        StackPane spMakas = new StackPane(imgMakas, spOrta);
        spMakas.setAlignment(Pos.BASELINE_LEFT);
        
        spKazandi=new StackPane(imgKazandi,spOrta);
        spKazandi.setAlignment(Pos.CENTER);
        spBeraberlik=new StackPane(imgBerabere,spOrta);
        spBeraberlik.setAlignment(Pos.CENTER);
        spKaybetti=new StackPane(imgKaybetti,spOrta);
        spKaybetti.setAlignment(Pos.CENTER);
        
        StackPane pcT = new StackPane(pcTas, spOrta);
        pcT.setAlignment(Pos.BASELINE_LEFT);
        StackPane pcK = new StackPane(pcKagıt, spOrta);
        pcK.setAlignment(Pos.BASELINE_LEFT);
        StackPane pcM = new StackPane(pcMakas,spOrta);
        pcM.setAlignment(Pos.CENTER);
        
                            
        
        // İlk gözüken arayüzde "Oyuna Başla!" butonuna basılınca...
        btnBasla.setOnAction(e->{
            secim = txt.getText();
            if (secim==null) {
                secim=txt.getText();
                bp.setLeft(spTas);
                kSecim=1;
            }else switch (secim) {
                case "taş":
                    bp.setLeft(spTas);
                    kSecim=1;
                    break;
                case "kağıt":
                    bp.setLeft(spKagit);
                    kSecim=2;
                    break;
                case "makas":
                    bp.setLeft(spMakas);
                    kSecim=3;
                    break;
                default:
                    bp.setLeft(spTas);
                    kSecim=1;
                    break;
            }
            
            
            baslat();
        
        });
        
        // İlk gözüken arayüzde imleç, isim girme alanında iken klavyedeki herhangi bir tuşa basılınca...
            txt.setOnAction(e->{
            secim = txt.getText();
            if (secim==null) {
                secim=txt.getText();
                bp.setLeft(spTas);
                kSecim=1;
            }else switch (secim) {
                case "taş":
                    bp.setLeft(spTas);
                    kSecim=1;
                    break;
                case "kağıt":
                    bp.setLeft(spKagit);
                    kSecim=2;
                    break;
                case "makas":
                    bp.setLeft(spMakas);
                    kSecim=3;
                    break;
                default:
                    bp.setLeft(spTas);
                    kSecim=1;
                    break;
            }
            
            
            baslat();
        
        });
        Button btn=new Button("Rakibi Göster");
        
        bp = new BorderPane();
        bp.setCenter(btn);
       
        bSecim=(int)(Math.random()*3)+1;
        switch (bSecim) {
            case 1:
                btn.setOnAction(e->{
                    bp.setRight(pcT);
                    KazandiMi();
                });
                break;
            case 2:
                btn.setOnAction(e->{
                    bp.setRight(pcK);
                    KazandiMi();
                });
                break;
            default:
                btn.setOnAction(e->{
                    bp.setRight(pcM);
                    KazandiMi();
                });
                break;
        }
        
        
        if (null == secim) {
              bp.setLeft(spTas);
              kSecim=1;
          }else switch (secim) {
            case "taş":
                kSecim=1;
                break;
            case "kağıt":
                bp.setLeft(spKagit);
                kSecim=2;
                break;
            case "makas":
                bp.setLeft(spMakas);
                kSecim=3;
                break;
            default:
                bp.setLeft(spTas);
                kSecim=1;
                break;
        }
  }
    
     public void baslat() {
    secim=txt.getText();
    // Herhangi bir isim girilmezse, default olarak bir isim belirlenir
    if (!"".equals(txt.getText())) {
      secim = txt.getText();
    } 
    
    scene = new Scene(bp, sceneWidth, sceneHeight);
    anaPencere.setResizable(false);


    // sahne değişiminde ekranın yeniden ortalanması gerekir
        anaPencere.setScene(scene);
        anaPencere.setTitle("Taş Kağıt Makas Oyuncu: " + secim);
        ekraniOrtala();
        
  }
   
    public void ekraniOrtala() {
    // Sahne değişimlerde ekranın orta yeri arayüz boyutlarına göre yeniden hesaplanmalıdır
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    anaPencere.setX((screenBounds.getWidth() - anaPencere.getWidth()) / 2);
    anaPencere.setY((screenBounds.getHeight() - anaPencere.getHeight()) / 2);
  }
    
    public static void main(String[] args) {    
        launch(args);
    }
    public void KazandiMi(){
        int yeniK=kSecim;
        int yeniB=bSecim;
        
        if(yeniK==yeniB){
           bp.setBottom(spBeraberlik);
        }else if(yeniK==1&&yeniB==2){
            bp.setBottom(spKaybetti);
        }else if(yeniK==1&&yeniB==3){
            bp.setBottom(spKazandi);
        }else if(yeniK==2&&yeniB==1){
            bp.setBottom(spKazandi);
        }else if(yeniK==2&&yeniB==3){
            bp.setBottom(spKaybetti);
        }else if(yeniK==3&&yeniB==1){
            bp.setBottom(spKaybetti);
        }else if(yeniK==3&&yeniB==2){
            bp.setBottom(spKazandi);
        }
        
        Button rest=new Button("Tekrar Oyna");
        bp.setCenter(rest);
        
        rest.setOnAction(e->{
            start(anaPencere);
            ekraniOrtala();
        });
        
}
}



