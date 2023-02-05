import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class BlackJackPanel extends JPanel implements ActionListener
{
   JFrame frame = new JFrame();

   JButton drawButton = new JButton("Draw");   //local
   JButton passButton = new JButton("Pass");   //local
   JButton dealButton = new JButton("Deal");   //local
   JButton newGameButton = new JButton("New Game");
   JPanel dealerPanel = new JPanel();
   JPanel playerPanel = new JPanel();
   JPanel buttonPanel = new JPanel();

   JPanel dC = new JPanel();
   JPanel pC = new JPanel();

   JLabel playerLabel;
   JLabel dealerLabel;
   Deck deck = new Deck();
   Player player = new Player();
   Dealer dealer = new Dealer();
   boolean playerFlag;
   boolean hasAce;
   int i = 1;
   ImageIcon icon;
   int playerTotal;
   int dealerTotal;
   JLabel dCLabel;
   JLabel pCLabel;

   public BlackJackPanel()
   {
      prepareGUI();
      setUpButtonListeners();
   }
   
   public void prepareGUI()
   {
      playerTotal = 0;
      dealerTotal = 0;
      frame.setTitle("Black Jack - By Sahil Narula & Jazib Malik");
      FlowLayout experimentLayout = new FlowLayout();
      frame.getContentPane().setLayout(experimentLayout);
      frame.setVisible(true);
      frame.setBounds(0,0,900,900);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.setLayout(new GridLayout(5,1));
      buttonPanel.setLayout(new FlowLayout());
      frame.add(buttonPanel);

      buttonPanel.add(drawButton);
      buttonPanel.add(passButton);
      buttonPanel.add(dealButton);
      buttonPanel.add(newGameButton);
      newGameButton.setEnabled(false);
      dCLabel = new JLabel("Dealer Cards:" + dealerTotal); 
      dC.add(dCLabel);
      frame.add(dC);
      
      
      dealerPanel.setLayout(new FlowLayout());
      frame.add(dealerPanel);
      pCLabel = new JLabel("Player Cards:"+ playerTotal);
      pC.add(pCLabel);
      frame.add(pC);

      playerPanel.setLayout(new FlowLayout());
      frame.add(playerPanel); 

      playerFlag = true;
      deck.shuffle();
   }

   public void isGameOver()
   {  
      if(playerTotal == 21)
      {
         drawButton.setEnabled(false);
         JOptionPane.showMessageDialog(frame, "Player Won!");
         newGameButton.setEnabled(true);
      }
      else if (playerTotal > 21) 
      {
         drawButton.setEnabled(false);
         JOptionPane.showMessageDialog(frame, "Player lost! Try again...");
         newGameButton.setEnabled(true);
         passButton.setEnabled(false);
         //reveal the hidden card if Player busts before dealer's turn
         playerFlag = false;
         dealerPanel.remove(1);
         icon = (new ImageIcon(((new ImageIcon("Image/"  + dealer.dealerCards.get(1).jpg + ".png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
         dealerLabel = new JLabel(icon);
         dealerPanel.add(dealerLabel);
         dealerTotal += dealer.dealerCards.get(i).faceValue;
         dCLabel.setText("Dealer Cards: Total: " + String.valueOf(dealerTotal));
         frame.pack();
         frame.setBounds(0,0,900,900);
         
      }
      else if (dealerTotal > 21) 
      {
         drawButton.setEnabled(false);
         JOptionPane.showMessageDialog(frame, "Player Won!");
         newGameButton.setEnabled(true);
      } 
      else if(playerTotal == dealerTotal)
      {
         drawButton.setEnabled(false);
         JOptionPane.showMessageDialog(frame, "Tie!");
         newGameButton.setEnabled(true);
      }
      else if(dealerTotal > playerTotal)
      {
         
         drawButton.setEnabled(false);
         JOptionPane.showMessageDialog(frame, "Player lost! Try again...");  
         newGameButton.setEnabled(true);   
      }
      else if ((playerTotal > dealerTotal) && (dealerTotal >= 17))
      {
         drawButton.setEnabled(false);
         JOptionPane.showMessageDialog(frame, "Player Won!");
         newGameButton.setEnabled(true);
      }
   }

  public void setUpButtonListeners()
  {
      ActionListener buttonListener = new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e)
         { 
            if (e.getSource() == drawButton)       //DRAW BUTTON
            {
               if (playerFlag)
               {
                  player.addPlayerCard(deck.deck.get(0));
                  int temp = playerTotal + player.playerCards.get(player.playerCards.size() - 1).faceValue;
                  System.out.println("Temp:" + temp);
                 
               for (int i = 0; i < player.playerCards.size(); i++) 
               {
                   
                  if(player.playerCards.get(i).letter.equals("A"))
                  {
                
                     if ((temp > 21))
                     {
                        player.playerCards.get(i).faceValue = 1; 
            
                     }
                  }
               }
                  
                  System.out.println(deck.deck.get(0).jpg);
                  deck.deck.remove(0);
     
               ImageIcon icon = (new ImageIcon(((new ImageIcon("Image/" + player.playerCards.get(player.playerCards.size()-1).jpg + ".png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
               
               playerLabel = new JLabel(icon);
               playerPanel.add(playerLabel);
               

              playerTotal = 0;
              for (int i = 0; i < player.playerCards.size(); i++) 
              {
               playerTotal += player.playerCards.get(i).faceValue;
              }
               pCLabel.setText("Player Cards: Total: " + String.valueOf(playerTotal));
               
               }

               frame.pack();
               frame.setBounds(0,0,900,900);
               isGameOver();
            }
               if (e.getSource() == passButton)       //PASS BUTTON
               {
                  playerFlag = false;
                  dealerPanel.remove(1);
                  icon = (new ImageIcon(((new ImageIcon("Image/"  + dealer.dealerCards.get(1).jpg + ".png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
                  dealerLabel = new JLabel(icon);
                  dealerPanel.add(dealerLabel);
                  dealerTotal += dealer.dealerCards.get(i).faceValue;
                  dCLabel.setText("Dealer Cards: Total: " + String.valueOf(dealerTotal));
                  frame.pack();
                  frame.setBounds(0,0,900,900);

                  while(dealerTotal < 17)
                  {
                  dealer.addDealerCard(deck.deck.get(0));
                  int temp1 = dealerTotal + dealer.dealerCards.get(dealer.dealerCards.size() - 1).faceValue;

                  for (int i = 0; i < dealer.dealerCards.size(); i++) 
                  {

                     if(dealer.dealerCards.get(i).letter.equals("A"))
                     {
               
                        if ((temp1 > 21))
                        {
                           dealer.dealerCards.get(i).faceValue = 1; 
                         
                        }
                     }
                  }
                  deck.deck.remove(0);
     
                  ImageIcon icon = (new ImageIcon(((new ImageIcon("Image/" + dealer.dealerCards.get(dealer.dealerCards.size()-1).jpg + ".png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
               
                  dealerLabel = new JLabel(icon);
                  dealerPanel.add(dealerLabel);
                  dealerTotal = 0;
                  for (int i = 0; i < dealer.dealerCards.size(); i++) 
                  {
                  dealerTotal += dealer.dealerCards.get(i).faceValue;
                  }
                  dCLabel.setText("Dealer Cards: Total: " + String.valueOf(dealerTotal));
                  }
                  passButton.setEnabled(false);
                  isGameOver();
                  
               }
               if (e.getSource() == dealButton)       //DEAL BUTTON
               {
                 // System.out.println("Deck Size: " + deck.deck.size());
                  if(deck.deck.size() < 10)    
                  {
                     deck = null;
                     deck = new Deck();
                     deck.shuffle();
                  }
                  deck.deal(player, dealer);

                  for(int i = 0; i < player.playerCards.size(); i++)
                  {
                     icon = (new ImageIcon(((new ImageIcon("Image/" + player.playerCards.get(i).jpg + ".png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
                     playerLabel = new JLabel(icon);
                     playerPanel.add(playerLabel);

                     playerTotal += player.playerCards.get(i).faceValue;
                     pCLabel.setText("Player Cards: Total: " + String.valueOf(playerTotal));
                     
                     if (i==0)
                     {
                     icon = (new ImageIcon(((new ImageIcon("Image/" + dealer.dealerCards.get(i).jpg + ".png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
                     dealerTotal += dealer.dealerCards.get(i).faceValue;   
                     }
                     else
                     {
                        icon = (new ImageIcon(((new ImageIcon("Image/"  + "53.png")).getImage()).getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
                     }
                     dealerLabel = new JLabel(icon);
                     dealerPanel.add(dealerLabel);
                     dCLabel.setText("Dealer Cards: Total: " + String.valueOf(dealerTotal));
                  }

                  if(playerTotal == 21)
                  {
                     isGameOver();
                  }

                  System.out.print(playerTotal);
                  System.out.print(dealerTotal);
                  dealButton.setEnabled(false);
                  frame.pack();
                  frame.setBounds(0,0,900,900);
               }   
               if (e.getSource() == newGameButton)       //NEW GAME BUTTON
               {
                  resetGame();
               }   
         }
      };
            drawButton.addActionListener(buttonListener);
            passButton.addActionListener(buttonListener);
            dealButton.addActionListener(buttonListener);
            newGameButton.addActionListener(buttonListener);
   }

   public void resetGame()
   {
      for(int i = 0; i < player.playerCards.size(); i++)
      {
         playerPanel.remove(0);
      }
     for(int j = 0; j < dealer.dealerCards.size(); j++)
      {
         dealerPanel.remove(0);
      }          
      playerFlag = true;
      playerTotal = 0;
      dealerTotal = 0;
      player.playerCards.removeAll(player.playerCards);
      dealer.dealerCards.removeAll(dealer.dealerCards);

      dCLabel.setText("Dealer Cards: Total: " + String.valueOf(dealerTotal));
      pCLabel.setText("Player Cards: Total: " + String.valueOf(playerTotal));
      
      drawButton.setEnabled(true);
      passButton.setEnabled(true);
      dealButton.setEnabled(true);
      newGameButton.setEnabled(false);

      frame.pack();
      frame.setBounds(0,0,900,900);
   }

@Override
public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   
} 
}
