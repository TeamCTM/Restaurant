import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

public class TextureSelector {

  static Icon oneIcon = new ImageIcon("walnut.png");
			
  static Icon twoIcon = new ImageIcon("mahogany.png");
	
  static Icon threeIcon = new ImageIcon("cherry.png");

  static Icon fourIcon = new ImageIcon("chestnut.png");

  static Icon fiveIcon = new ImageIcon("beech.png");

  static Icon sixIcon = new ImageIcon("cherry.jpg");

  public static void main(String args[]) {

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent
            .getSource();
        boolean selected = aButton.getModel().isSelected();
        System.out.println(actionEvent.getActionCommand()
            + " - selected? " + selected);
      }
    };

    ItemListener itemListener = new ItemListener() {
      public void itemStateChanged(ItemEvent itemEvent) {
        AbstractButton aButton = (AbstractButton) itemEvent.getSource();
        int state = itemEvent.getStateChange();
        String selected = ((state == ItemEvent.SELECTED) ? "selected"
            : "not selected");
        System.out.println(aButton.getText() + " - selected? "
            + selected);
      }
    };

    JFrame frame = new JFrame("Set Up Wizard");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Wood Table Texture Selector");
    ButtonGroup buttonGroup = new ButtonGroup();
    menu.setMnemonic(KeyEvent.VK_M);

    JRadioButtonMenuItem emptyMenuItem = new JRadioButtonMenuItem();
    emptyMenuItem.setActionCommand("Empty");
    emptyMenuItem.addActionListener(actionListener);
    buttonGroup.add(emptyMenuItem);
    menu.add(emptyMenuItem);

    JRadioButtonMenuItem oneMenuItem = new JRadioButtonMenuItem("Walnut",oneIcon,true);
    oneMenuItem.addActionListener(actionListener);
    buttonGroup.add(oneMenuItem);
    menu.add(oneMenuItem);

    JRadioButtonMenuItem twoMenuItem = new JRadioButtonMenuItem(
        "Mahogany", twoIcon, true);
    twoMenuItem.addActionListener(actionListener);
    buttonGroup.add(twoMenuItem);
    menu.add(twoMenuItem);

    JRadioButtonMenuItem threeMenuItem = new JRadioButtonMenuItem(
        "Cherry", threeIcon);
    threeMenuItem.addItemListener(itemListener);
    buttonGroup.add(threeMenuItem);
    menu.add(threeMenuItem);

    JRadioButtonMenuItem fourMenuItem = new JRadioButtonMenuItem(
        "Chestnut", fourIcon, true);
    fourMenuItem.addActionListener(actionListener);
    buttonGroup.add(fourMenuItem);
    menu.add(fourMenuItem);

    JRadioButtonMenuItem fiveMenuItem = new JRadioButtonMenuItem("Beech",fiveIcon,true);
    fiveMenuItem.addActionListener(actionListener);
    fiveMenuItem.setActionCommand("Beech");
    buttonGroup.add(fiveMenuItem);
    menu.add(fiveMenuItem);

    JRadioButtonMenuItem sixMenuItem = new JRadioButtonMenuItem(sixIcon,
        true);
    sixMenuItem.addActionListener(actionListener);
    sixMenuItem.setActionCommand("Black");
    buttonGroup.add(sixMenuItem);
    menu.add(sixMenuItem);

    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
    frame.setSize(350, 350);
    frame.setLocation(500,300);
    frame.setVisible(true);
  }
}
