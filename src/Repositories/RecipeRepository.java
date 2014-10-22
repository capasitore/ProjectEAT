package Repositories;

import java.awt.List;
import java.util.ArrayList;

import Model.Recipe;

public class RecipeRepository {

	public ArrayList<Recipe> GetAll()
	{
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		// Pasta carbonara
		Recipe pastaCarbonara = new Recipe();
		pastaCarbonara.setName("Pasta Carbonara");
		pastaCarbonara.setCousine("Italian");
		pastaCarbonara.setTimeReq("20 min");
		recipes.add(pastaCarbonara);
		
		Recipe chickenAlfredo = new Recipe();
		chickenAlfredo.setName("Chicken Alfredo");
		chickenAlfredo.setCousine("Spanish");
		chickenAlfredo.setTimeReq("30 min");
		recipes.add(chickenAlfredo);
		
		
		return recipes;
	}
	
}
