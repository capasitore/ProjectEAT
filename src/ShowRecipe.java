import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
public class ShowRecipe extends JPanel {
	
	//Serialized
	private static final long serialVersionUID = 4148477691155070180L;

	//GUI Components
	JPanel mainContainer, headerContainer, header, header2, ingredientPanel, instructionPanel;
	JLabel picture, recipeName, cuisine, timeRequired, portion;
	JLabel[] ingredient, instruction;
	BufferedImage recipePicture;
	Font defaultFont, headingFont;

	public ShowRecipe(String name, String cuisineType, int time, int servings,
			String[] ingredients, String[] quantity, String[] instructions){
		//Set the default font to Arial and size to 20
		defaultFont = new Font("Arial", Font.PLAIN, 20);
		headingFont = new Font("Arial", Font.PLAIN, 30);
		
		//Panels & Layout
		mainContainer = new JPanel();
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));
		headerContainer = new JPanel();
		header = new JPanel();
		header2 = new JPanel();
		header2.setLayout(new BoxLayout(header2, BoxLayout.PAGE_AXIS));
		ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new GridLayout(0, 5));
		ingredientPanel.setBorder(BorderFactory.createTitledBorder("Ingredients"));
		((TitledBorder)ingredientPanel.getBorder()).setTitleFont(headingFont);
		instructionPanel = new JPanel();
		instructionPanel.setLayout(new GridLayout(0, 1));
		instructionPanel.setBorder(BorderFactory.createTitledBorder("How to"));
		((TitledBorder)instructionPanel.getBorder()).setTitleFont(headingFont);

		/*
		 * Placeholder Image Loader for now
		 * Correct Implementation: Constructor should take a BufferedImage as argument
		 */
		try {
			recipePicture = ImageIO.read(this.getClass().getResource("placeholder.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Labels
		picture = new JLabel(new ImageIcon(recipePicture));
		
		recipeName = new JLabel(name);
		recipeName.setFont(new Font("Arial", Font.BOLD, 60));
		
		cuisine = new JLabel(cuisineType);
		cuisine.setFont(defaultFont);
		
		timeRequired = new JLabel("Approx. " + Integer.toString(time) + " min");
		timeRequired.setFont(defaultFont);
		
		portion = new JLabel("Enough for " + Integer.toString(servings) + " servings");
		portion.setFont(defaultFont);
		
		ingredient = new JLabel[ingredients.length];
		for(int x=0; x<ingredients.length; x++){
			ingredient[x] = new JLabel(quantity[x] + " " + ingredients[x]);
			ingredient[x].setFont(defaultFont);
		}
		
		instruction = new JLabel[instructions.length];
		for(int y=0; y<instructions.length; y++){
			instruction[y] = new JLabel(y+1 + ". " + instructions[y]);
			instruction[y].setFont(defaultFont);
			instruction[y].setAlignmentX(Component.LEFT_ALIGNMENT);//0.0
		}
		
		addComponentsToPanel();
	}
	
	private void addComponentsToPanel() {
		header.add(picture);
		header2.add(recipeName);
		header2.add(cuisine);
		header2.add(timeRequired);
		header2.add(portion);
		
		for(int x=0; x<ingredient.length; x++){
			ingredientPanel.add(ingredient[x]);
		}
		
		for(int x=0; x<instruction.length; x++){
			instructionPanel.add(instruction[x]);
		}
		
		headerContainer.add(header);
		headerContainer.add(header2);
		mainContainer.add(headerContainer);
		mainContainer.add(ingredientPanel);
		mainContainer.add(instructionPanel);
		add(mainContainer);
	}
}
