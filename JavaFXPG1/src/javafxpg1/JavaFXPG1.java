package javafxpg1;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXPG1 extends Application {
    public static int Width=1280;
    public static int Height=720;
    public static int rotation=45;
    @Override
    public void start(Stage primaryStage) {
        Box b = new Box(), b1 = new Box();
        b.setWidth(200.0);
        b.setHeight(200.0);
        b.setDepth(200.0);
        b1.setWidth(10000.0);
        b1.setHeight(100.0);
        b1.setDepth(1500.0);
        b1.setTranslateZ(400);
        PhongMaterial m = new PhongMaterial(), m1 = new PhongMaterial();
        m.setDiffuseColor(Color.RED);
        m1.setDiffuseColor(Color.GREEN);
        b.setMaterial(m);
        b1.setMaterial(m1);
        b.setTranslateX((Width/2));
        b.setTranslateY((Height/2));
        b1.setTranslateX((Width/2));
        b1.setTranslateY((Height/2)+200);
        AmbientLight al = new AmbientLight();
        al.setColor(Color.rgb(140,100,100,.1));
        PointLight p = new PointLight();
        p.setColor(Color.YELLOW);
        p.getTransforms().add(new Translate(100,-500,150));
        Camera camera = new PerspectiveCamera();
        camera.setTranslateZ(-1000);
        
        
        //b1.setRotate(10);
       // b1.setRotationAxis(new Point3D(1, 0, 0));
        
        //b.setRotate(10);
        //b.setRotationAxis(new Point3D(1, 0, 0));
        //b.setTranslateY((Height/2)+100);
        //b.setTranslateZ(-500);
        
        
        Rotate rotate=new Rotate(0,Rotate.Y_AXIS);
        b.getTransforms().add(rotate);
        RotateTransition rt = new RotateTransition(Duration.seconds(.3),b);
        RotateTransition mrt = new RotateTransition(Duration.seconds(.3),b);
        rt.setByAngle(90);
        mrt.setByAngle(-90);
       
        
       primaryStage.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, event->{
           switch(event.getCode())
           {
               case UP:
                    b.translateZProperty().set(b.getTranslateZ()-5);
                    b1.translateZProperty().set(b1.getTranslateZ()-5);
                    break;
                case DOWN:
                    b.translateZProperty().set(b.getTranslateZ()+5);
                    b1.translateZProperty().set(b1.getTranslateZ()+5);
                    break;
                case RIGHT:
                    b.translateYProperty().set(b.getTranslateY()+5);
                    break;
                case LEFT:
                   b.translateYProperty().set(b.getTranslateY()-5);
                    break;
                case A:
                    b.translateXProperty().set(b.getTranslateX()-5);
                    mrt.play();
                    break;
                case D:
                    b.translateXProperty().set(b.getTranslateX()+5);
                    rt.play();
                    break;
           }
       });
       
        Group g = new Group(b,b1,al,p,camera);
        Scene s = new Scene(g , Width, Height);
        s.setCamera(camera);
        s.setFill(Color.SILVER);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
