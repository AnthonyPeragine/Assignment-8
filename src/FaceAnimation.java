
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ${user}
 */
public class FaceAnimation extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;


    // GAME VARIABLES WOULD GO HERE
    double eyebrowOneX = 250;
    double eyebrowOneY = 140;
    
    double eyebrowTwoX = 450;
    double eyebrowTwoY = 150;

    int eyeSize = 40;
    
    int eyeOneX = 275;
    int eyeTwoX = 475;
    
    double add = 0.3;
    double addThree = 0.4;
    int addTwo = 1;
    // GAME VARIABLES END HERE   

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 
        Color beige = new Color(230, 201, 201);
        
        //base of the face
        g.setColor(beige);
        g.fillOval(200, 100, 400, 400);
        
        //ears
        g.fillArc(190, 200, 110, 110, 130, 100);
        g.fillArc(500, 200, 110, 110, 310, 100);
        
        //bigger circles of the eyes
        g.setColor(Color.BLACK);
        g.fillOval(250, 170, 100, 100);
        g.fillOval(450, 170, 100, 100);
        
        //smaller white circles used as pupils
        g.setColor(Color.WHITE);
        g.fillOval(eyeOneX, 195, eyeSize, eyeSize);
        g.fillOval(eyeTwoX, 195, eyeSize, eyeSize);
        
        //nervous mouth
        g.setColor(Color.BLACK);
        g.fillArc(75, 340, 400, 150, 340, 100);
        
        //nose
        g.drawArc(370, 270, 60, 60, 100, 200);
        
        //tongue 
        g.setColor(Color.PINK);
        g.fillRoundRect(330, 380, 100, 50, 100, 50);
        
        //both eyebrows
        g.setColor(Color.BLACK);
        g.fillRect((int)eyebrowOneX, (int)eyebrowOneY, 100, 20);
        g.fillRect((int)eyebrowTwoX, (int)eyebrowTwoY, 100, 20);
        
        
        // GAME DRAWING ENDS HERE
    }


    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void  preSetup(){
       // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
                
                //makes eyebrows move up and down
                
                eyebrowOneY = eyebrowOneY + add;
                if(eyebrowOneY > 155 || eyebrowOneY < 140){
                    add = add * -1;
                }
                
               // eyebrowTwoY = eyebrowTwoY + addThree;
              //  if(eyebrowTwoY > 165 || eyebrowTwoY < 150){
               //     addThree = addThree * -1;
              //  }

                //makes pupils look side to side like a nervous person
                eyeOneX = eyeOneX + addTwo;
                eyeTwoX = eyeTwoX + addTwo;
                if(eyeOneX > 295 || eyeOneX < 275){
                    addTwo = addTwo * -1;
                }
                
                
               
            
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        FaceAnimation game = new FaceAnimation();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());
        
        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e){
            
        }
        
        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e){
            
        }
        
        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e){
            
        }
    }
    
    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter{
        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e){
            
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e){
            
        }
    }
}


