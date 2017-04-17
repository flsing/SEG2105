package com.example.eyobt.cook;


import java.util.LinkedList;
import java.util.List;


/**
 * Created by Eyob.T on 2016-12-03.
 */

public class StoredRecipe {
    private static StoredRecipe ourInstance = null; // initializing sole instance to null
    List<Recipe>  reci = new LinkedList<Recipe>(); // list to store ALL recipes
    private List<Recipe> searchedRecipes = new LinkedList<Recipe>(); // list to store SEARCHED recipes

    /**
     * list for instructions of stored recipes
     */
    private   List<Ingredient> iHotChoc = new LinkedList<Ingredient>();
    private List<Ingredient> iMacAndCheese = new LinkedList<Ingredient>();
    private List<Ingredient> iFrenchToast = new LinkedList<Ingredient>();
    private  List<Ingredient> iChickenCurry = new LinkedList<Ingredient>();
    private List<Ingredient> iThaiChickenSoup = new LinkedList<Ingredient>();
    private List<Ingredient> iKheer = new LinkedList<Ingredient>();
    private  List<Ingredient> iJollofRice = new LinkedList<Ingredient>();
    private List<Ingredient> iTibs = new LinkedList<Ingredient>();

    //Steps for hotChoco
    String sHotChoc = ("1. Add milk into cup \n 2. Add sugar and vanilla extract into cup \n" +
            " 3. Add cocoa powder and water into cup \n 4.Drink UP !");


    //Steps for Mac&Cheese
    String sMacAndCheese = ("1.Prepare oven to 400 degrees \n 2.Fill a large pot with lightly salted " +
            "water and bring to a boil over high heat. Once the water is boiling, stir in the macaroni" +
            " Cook the pasta uncovered, stirring occasionally, until the pasta is cooked through but " +
            "still slightly firm, about 8 minutes " +
            "\n 3.Stir in nutmeg, Worcestershire sauce, and salt; simmer on medium-low heat " +
            "\n 4.Turn heat off, then add 2 1/4 cups of Cheddar cheese;" +
            "\n 5.Add Dijon mustard. \n 6.pour in the cheese sauce" +
            "\n 6.Mix panko bread crumbs and 1 tablespoon melted butter in a small bowl" +
            "\n 7.Bake in the preheated oven until bread crumbs and Cheddar cheese topping are golden brown, " +
            "about 20 minutes.");

    //steps for FrenchToast
    String sFrenchToast = ("1.Add some milk in a bowl \n 2.Add one egg in the same bowl " +
            "\n 3.Add 1 tbs sugar in the same bowl and mix \n 4.Take slice of bread and dip in the liquid mixture " +
            "\n 5.Cook the bread in a pan on medium heat \n 6.Enjoy your French Toast!");

    //steps for ChickenCurry = new String
    String sChickencurry = ("1.Cook boneless chicken on medium heat " +
            "\n 2.Heat olive oil in a skillet \n 3.Saute onion until lightly browned " +
            "\n 4.Stir with garlic, curry powder and cinnamon for 2 minutes " +
            "\n 5.Mix chicken and curry");


    //steps for ThaiChickenSoup = new String
    String sThaiChickenSoup = ("1.Cook chickenstrips on medium heat  " +
            "\n 2.Heat olive oil in a skillet \n 3.Stir in mushrooms and cook for 5 more minutes " +
            "\n 4.Stir in red curry paste \n 5.Stir in chicken broth and coconut milk " +
            "\n 6.cook on low for 15 to 20 minutes");


    //steps for Kheer = new String
    String sKheer = ("1.Bring the coconut milk, milk and sugar to a boil in a large saucepan " +
            "\n 2.Add Basmati rice, and simmer over low heat until the mixture thickens about 20 minutes " +
            "\n 3.Stir in the raisins, cardamom and rose water, and cook for a few more minutes");

    //steps for JollofRice = new String
    String sJollofRice = ("1.Pour the chicken stock and the tomato stew into pot and to boil " +
            "\n 2.Add the drained parboiled rice, curry powder, salt and pepper to taste " +
            "\n 3.The water level should be the same level of the rice " +
            "\n 4.Cover the pot and leave to cook on low to medium heat");

    //steps for Tibs
    String sTibs = ("1.Chop the beef into small cubes " +
            "\n 2.Add beef into pan with oil. " +
            "\n 3.Stir in the butter and spices of your choosing"+
            "\n 4.Serve in Injera" +
            "\n 5. Don't for get to share!");


    //Ingredients for Mac&Cheese
    Ingredient cheese = new Ingredient("Cheese");
    Ingredient macaroni = new Ingredient("Macaroni");
    Ingredient water = new Ingredient("Water");

    //Ingredients for HotChoco
    Ingredient milk = new Ingredient("Milk" );
    Ingredient sugar = new Ingredient("Sugar");
    Ingredient cocoaPowder = new Ingredient("CocoaPowder");
    Ingredient vanillaExtract = new Ingredient("Vanilla Extract");

    //Ingredients for FrenchToast
    Ingredient egg = new Ingredient("egg");
    Ingredient toast = new Ingredient("toast");

    //Ingredients for ChickenCurry
    Ingredient chicken = new Ingredient("Chicken" );
    Ingredient oliveOil = new Ingredient("Oilve Oil");
    Ingredient curryPowder = new Ingredient("Curry Powder");
    Ingredient garlic = new Ingredient(" Garlic");

    //Ingredients for ThaiSoup
    Ingredient chickenStrips = new Ingredient("Chicken strips" );
    Ingredient mushroom = new Ingredient("Mushhroom");
    Ingredient cocoMilk = new Ingredient("Coconut Milk");

    //Ingredients for Kheer
    Ingredient rice = new Ingredient("Rice" );
    Ingredient onion = new Ingredient("Raisin");

    //Ingredients for JollofRice
    Ingredient salt = new Ingredient("Salt" );
    Ingredient pepper = new Ingredient("Pepper");
    Ingredient tomato = new Ingredient("Tomato");

    //ingredients for Tibs
    Ingredient beef = new Ingredient("Beef");
    Ingredient butter = new Ingredient("Butter");
    Ingredient injera = new Ingredient("Injera");



// pictures for each pre-stored recipe
    int pastaPic = R.drawable.chef;
    int tibsPic = R.drawable.injeraa;
    int jollofRicePic = R.drawable.jollofrice;
    int kheerPic = R.drawable.kheer;
    int chickenCurryPic = R.drawable.chickencurry;
    int frenchToastPic = R.drawable.frenchtoast;
    int thaiSoup = R.drawable.chickenthaisoup;
    int hotChocPic = R.drawable.chef;
    int manCheesePic = R.drawable.injeraa;

    /**
     * returns all the recipes in memory
     * @return reci; linkedList with all recipes
     */
    public List<Recipe> getRecipes (){
        return reci;
    }

    /**
     * returns recipes that match search criteria
     * @return result; new linkedList with all relevant recipes from search query
     */
    public List<Recipe> getSearchedRecipes(){
        List<Recipe>  result =  new LinkedList<Recipe>();
        for (int i =0;i<searchedRecipes.size();i++){
            result.add(searchedRecipes.get(i));
        }
        searchedRecipes.clear();
        return result;}

    /**
     * returns the ingredients of selected recipe
     * @param i position of recipe
     * @return the ingredients for the recipe at i
     */
    public List<Ingredient> getIngredients (int i){
        return reci.get(i).ingredients;
    }

    /**
     * returns the steps of a specific recipe in the memory
     * @param aRecipe the specific recipe
     * @return the steps of aRecipe
     */
    public String getSteps (Recipe aRecipe){
        return aRecipe.steps;
    }

    //Recipe hotChoc = new Recipe("Hot Chocolate", "Canadian" ,"Drink", pastaPic,iHotChoc,sHotChoc);

    /**
     * returns the sole instance
     * @return the only instance of StoredRecipe
     */
    public static StoredRecipe getInstance() {

        if (ourInstance == null){
            ourInstance = new StoredRecipe();
            return ourInstance;
        }
        return ourInstance;
    }

    /**
     * constructor for singleton; StoredRecipe
     */
    private StoredRecipe() {

        //Mac&Cheese
        iMacAndCheese.add(cheese);
        iMacAndCheese.add(butter);
        iMacAndCheese.add(macaroni);

        //hotChoc
        iHotChoc.add(water);
        iHotChoc.add(milk);
        iHotChoc.add(sugar);
        iHotChoc.add(vanillaExtract);
        iHotChoc.add(cocoaPowder);

        //FrenchToast
        iFrenchToast.add(egg);
        iFrenchToast.add(toast);
        iFrenchToast.add(milk);
        iFrenchToast.add(sugar);
        iFrenchToast.add(butter);

        //ChickenCurry
        iChickenCurry.add(chicken );
        iChickenCurry.add(oliveOil );
        iChickenCurry.add(curryPowder );
        iChickenCurry.add(onion );
        iChickenCurry.add(garlic);

        //ThaiSoup
        iThaiChickenSoup.add(chickenStrips);
        iThaiChickenSoup.add(mushroom );
        iThaiChickenSoup.add(cocoMilk);
        iThaiChickenSoup.add(mushroom);
        iThaiChickenSoup.add(curryPowder);

        //Kheer
        iKheer.add(rice );
        iKheer.add(onion );
        iKheer.add(cocoMilk );
        iKheer.add(milk );
        iKheer.add(sugar);

        //JollofRice
        iJollofRice.add(salt);
        iJollofRice.add(pepper);
        iJollofRice.add(tomato);
        iJollofRice.add(rice);

        //Tibs
        iTibs.add(beef);
        iTibs.add(butter);
        iTibs.add(injera);

        // making recipes to be stored in local memory
        Recipe tibs = new Recipe("Tibs","Ethiopian","Main Dish", tibsPic,iTibs,sTibs);
        Recipe MacAndCheese = new Recipe("Mac And Cheese", "American","Main Dish", pastaPic, iMacAndCheese,sMacAndCheese);
        Recipe hotChoc = new Recipe("Hot Chocolate", "Canadian" ,"Drink", pastaPic,iHotChoc,sHotChoc);
        Recipe jollfRice = new Recipe("Jollof Rice","Nigerian","MainDish", pastaPic,iJollofRice,sJollofRice);
        Recipe thaiChickenSoup = new Recipe("Thai Chicken Soup", "Thai", "Appetizer", pastaPic,iThaiChickenSoup,sThaiChickenSoup);
        Recipe frenchToast = new Recipe("French Toast","England","Starter", pastaPic,iFrenchToast,sFrenchToast);
        Recipe kheer = new Recipe("Kheer", "Indian", "Main Dish", kheerPic,iKheer,sKheer);

        // adding recipes to memory (linkedList)
        reci.add(tibs);
        reci.add(MacAndCheese);
        reci.add(hotChoc);
        reci.add(jollfRice);
        reci.add(thaiChickenSoup);
        reci.add(frenchToast);
        reci.add(kheer);


    }


    /**
     * algorithm for adding recipe
     * @param aRecipe recipe being added
     */
    public void add(Recipe aRecipe){

        reci.add(aRecipe);

    }

    /**
     * algorithm for searching recipes by type
     * if recipe found -> stores in searchedRecipes
     * @param type user selected food type
     */
    public void searchByType(String type) {
        // s
                for (int i =0; i<reci.size();i++) {
                    if (reci.get(i).foodType.contains(type)) {
                        searchedRecipes.add(reci.get(i));
                    }
                }
        }

    /**
     *algorithm for searching recipes by category & ingredients
     * @param category user selected food category
     * @param ingredients user input of ingredients
     * method will cause errors when trying to run, hence its comented out
     */
        public void searchByIngredient(String category, String ingredients){
//          String [] ingredientArray = ingredients.split(",");
//            for (int i =0; i<reci.size();i++) {
//                if (reci.get(i).foodCategory.contains(category)) {
//                    int count =0;
//                    for (int y=0;i<ingredientArray.length;y++){
//                        if (reci.get(i).ingredients.contains(ingredientArray[y]))
//                            count ++;
//                    }
//                    if (count > 2)
//                    searchedRecipes.add(reci.get(i));
//                }
//            }
        }



}
