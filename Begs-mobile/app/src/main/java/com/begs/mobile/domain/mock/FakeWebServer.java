package com.begs.mobile.domain.mock;

import com.begs.mobile.model.CenterRepository;
import com.begs.mobile.model.entities.Producer;
import com.begs.mobile.model.entities.Product;
import com.begs.mobile.model.entities.ProductCategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FakeWebServer {

    static {
        initProducer();
    }

    private static FakeWebServer fakeServer;
    private static List<Producer> producers;

    public static FakeWebServer getFakeWebServer() {

        if (null == fakeServer) {
            fakeServer = new FakeWebServer();
        }
        return fakeServer;
    }

    void initiateFakeServer() {
        addCategory();
    }

    private static void initProducer() {
        producers = new ArrayList<>();
        producers.add(new Producer("A family owned farmer", "https://www.bizencyclopedia.com/admin/assets/img/blog/FamerPrCpo.jpg", "TheFarmers", "1"));
        producers.add(new Producer("Big boy store", "https://upload.wikimedia.org/wikipedia/en/thumb/1/12/Carrefour_logo_no_tag.svg/1200px-Carrefour_logo_no_tag.svg.png", "TheBigBoyz", "2"));
    }

    public void addCategory() {

        ArrayList<ProductCategoryModel> listOfCategory = new ArrayList<ProductCategoryModel>();

        listOfCategory
                .add(new ProductCategoryModel(
                        "Recommendations",
                        "Your recommendations based on interests",
                        "10%",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgZv1f9lmbkLLerRqGmvB0fKmypboogBnHukcE6m_g1dTZVN3t"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Newcomers",
                        "Items listed recently",
                        "15%",
                        "https://athleticlab.com/wp-content/uploads/2016/03/understandingcarbs-365x285.jpg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Products of the week",
                        "Best products this week",
                        "15%",
                        "https://athleticlab.com/wp-content/uploads/2016/03/understandingcarbs-365x285.jpg"));

        CenterRepository.getCenterRepository().setListOfCategory(listOfCategory);
    }


    public void getRecommendations() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Avocado",
                        " Best price    Best Seller     No restrictions",
                        "Avocados have a unique nutrition profile. They contain lots of fiber and are rich in vitamins and minerals, such as B-vitamins, vitamin K, potassium, copper, vitamin E and vitamin C.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://www.pledgesports.org/wp-content/uploads/2018/01/avocado.jpg",
                        "exoticf_1", producers.get(0)));

        productlist
                .add(new Product(
                        "Banana",
                        " Sponsored Content     No restrictions",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "2",
                        "10",
                        "2",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(0)));

        productlist
                .add(new Product(
                        "Kiwi Fruits",
                        " High user reviews     No restrictions",
                        "Kiwi’s beneficial phytonutrients combined with the fantastic lineup of vitamins and minerals kiwi nutrition provides create a delicious, nutrient-dense fruit with an impressive list of health benefits.",
                        "6",
                        "10",
                        "6",
                        "0",
                        "http://naturalpointibiza.com/wp-content/uploads/2015/12/aromat_kiwi.jpg",
                        "exoticf_3", producers.get(0)));

        productlist
                .add(new Product(
                        "Orange",
                        " Hot right now     Best Seller",
                        "Oranges are a healthy source of fiber, vitamin C, thiamine, folate, and antioxidants. They have multiple health benefits.",
                        "7",
                        "12",
                        "7",
                        "0",
                        "https://capitaltrick.com/wp-content/uploads/2018/12/Orange.jpg",
                        "exoticf_4", producers.get(0)));

        productlist
                .add(new Product(
                        "Lemon",
                        " Low Sugar     No restrictions",
                        "Lemons are a good source of vitamin C and of flavonoids, or antioxidants, which are thought to boost health and wellbeing in several ways.",
                        "8",
                        "10",
                        "8",
                        "0",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8gmE-98eschzi9GOIRq5gOZA27gzb3knJQGMwJYK8zFADfCnqYA",
                        "exoticf_5", producers.get(0)));

        productMap.put("Best fit for you", productlist);

        ArrayList<Product> bestQuality = new ArrayList<Product>();

        bestQuality.add(new Product(
                "Cherry",
                " Perfect for your high protein diet ",
                "Researchers found that eating cherries and products made with cherries decreased oxidative stress, inflammation, exercise-induced muscle soreness and loss of strength, LDL cholesterol, blood pressure, arthritis symptoms, and loss of sleep.",
                "10",
                "12",
                "10",
                "0",
                "https://cdn.images.express.co.uk/img/dynamic/109/590x/Cherries-824932.jpg",
                "fruits_1", producers.get(1)));

        bestQuality.add(new Product(
                "Cherry",
                " Local Grown ",
                "Eating cherries leads to a boost in antioxidant activity in the body. Cherries are a good source of anthocyanin, which can help enhance memory. The tasty fruit's anthocyanins helped improve memory and motor function in rats.",
                "10",
                "12",
                "10",
                "0",
                "https://cdn.pixabay.com/photo/2016/12/17/18/50/cherry-1914118__340.jpg",
                "fruits_2", producers.get(1)));

        bestQuality.add(new Product(
                "Apple ",
                " Best price-quality available ",
                "In red apples, quercetin a solid antioxidant found in the apple skin has the capacity to reduce oxidative stress apparently by blocking free radicals that could damage the brain cells",
                "10",
                "12",
                "10",
                "0",
                "https://ak1.ostkcdn.com/images/products/is/images/direct/0c72265542c1f86a5f3aabec9c19e239139dffbe/Red-Apples-by-Remo-Barbieri-Cuisine-Art-Print.jpg",
                "fruits_3", producers.get(1)));

        bestQuality.add(new Product(
                "Green Apple",
                " No pesticides were used ",
                "All apples have health benefits, but the thing that makes green apples special is that they have a high nutritional density packed with minerals, vitamins, proteins, and fiber. They help prevent digestive problems, help regulate blood glucose and good cholesterol.",
                "2",
                "12",
                "2",
                "0",
                "https://karmabest.ae/image/cache/catalog/Green-Apple-270x270.jpg",
                "fruits_4", producers.get(1)));

        bestQuality.add(new Product(
                "Golden Apple",
                "  Local grown in Iasi  ",
                "The caloric value of yellow apples varies based on the size of the apple. An apple with a diameter of approximately 2-1/2 inches has 90 calories. Apples contain no fat or protein that contributes to the total calorie value.",
                "3",
                "12",
                "3",
                "0",
                "https://karmabest.ae/image/cache/catalog/Golden%20apple-270x270.png",
                "fruits_5", producers.get(1)));

        productMap.put("Best quality", bestQuality);

        ArrayList<Product> bestValue = new ArrayList<Product>();

        bestValue
                .add(new Product(
                        "Grapes",
                        " Cheapest arround you ",
                        "A grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis. Grapes can be eaten fresh as table grapes or they can be used for making wine, jam, juice, jelly, grape seed extract, raisins, vinegar, and grape seed oil.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://3.imimg.com/data3/II/CD/MY-11501353/seedless-grapes-500x500.png",
                        "v_fruits_1", producers.get(1)));

        bestValue
                .add(new Product(
                        "Apricots",
                        " High producer reviews ",
                        "An apricot is a fruit, or the tree that bears the fruit, of several species in the genus Prunus. Usually, an apricot tree is from the species P. armeniaca, but the species P. brigantina, P. mandshurica, P. mume, P. zhengheensis and P. sibirica are closely related, have similar fruit, and are also called apricots. ",
                        "6",
                        "10",
                        "4",
                        "0",
                        "https://cdn.pixabay.com/photo/2018/05/27/16/19/apricots-3433818__340.jpg",
                        "v_fruits_2", producers.get(1)));

        bestValue
                .add(new Product(
                        "Peach",
                        " Best price quality available ",
                        "The peach is a deciduous tree native to the region of Northwest China between the Tarim Basin and the north slopes of the Kunlun Mountains, where it was first domesticated and cultivated. It bears an edible juicy fruit called a peach or a nectarine.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://thewoman.md/wp-content/uploads/2018/07/piersici.jpg",
                        "v_fruits_3", producers.get(1)));

        bestValue
                .add(new Product(
                        "Romanian Peach",
                        " Local Romanian product ",
                        "The peach is a deciduous tree native to the region of Northwest China between the Tarim Basin and the north slopes of the Kunlun Mountains, where it was first domesticated and cultivated. It bears an edible juicy fruit called a peach or a nectarine.",
                        "11",
                        "10",
                        "11",
                        "0",
                        "https://s3-media4.fl.yelpcdn.com/bphoto/I06fCgujvVvCOUqWB_TCvw/ls.jpg",
                        "v_fruits_4", producers.get(1)));

        productMap.put("Best value", bestValue);

        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);
    }

    public void getProductsOfTheWeek() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Avocado",
                        " High protein",
                        "Avocados have a unique nutrition profile. They contain lots of fiber and are rich in vitamins and minerals, such as B-vitamins, vitamin K, potassium, copper, vitamin E and vitamin C.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://www.pledgesports.org/wp-content/uploads/2018/01/avocado.jpg",
                        "exoticf_1", producers.get(0)));

        productlist
                .add(new Product(
                        "Banana",
                        " Fresh product",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "2",
                        "10",
                        "2",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(0)));

        productlist
                .add(new Product(
                        "Kiwi Fruits",
                        " Best Quality     High producer rating",
                        "Kiwi’s beneficial phytonutrients combined with the fantastic lineup of vitamins and minerals kiwi nutrition provides create a delicious, nutrient-dense fruit with an impressive list of health benefits.",
                        "6",
                        "10",
                        "6",
                        "0",
                        "http://naturalpointibiza.com/wp-content/uploads/2015/12/aromat_kiwi.jpg",
                        "exoticf_3", producers.get(0)));

        productlist
                .add(new Product(
                        "Orange",
                        " 20 people have bought today",
                        "Oranges are a healthy source of fiber, vitamin C, thiamine, folate, and antioxidants. They have multiple health benefits.",
                        "7",
                        "12",
                        "7",
                        "0",
                        "https://capitaltrick.com/wp-content/uploads/2018/12/Orange.jpg",
                        "exoticf_4", producers.get(0)));

        productlist
                .add(new Product(
                        "Lemon",
                        " Top recommendation this week",
                        "Lemons are a good source of vitamin C and of flavonoids, or antioxidants, which are thought to boost health and wellbeing in several ways.",
                        "8",
                        "10",
                        "8",
                        "0",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8gmE-98eschzi9GOIRq5gOZA27gzb3knJQGMwJYK8zFADfCnqYA",
                        "exoticf_5", producers.get(0)));


        productMap.put("Recommendations", productlist);

        productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Grapes",
                        " Hot right now",
                        "A grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis. Grapes can be eaten fresh as table grapes or they can be used for making wine, jam, juice, jelly, grape seed extract, raisins, vinegar, and grape seed oil.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://3.imimg.com/data3/II/CD/MY-11501353/seedless-grapes-500x500.png",
                        "v_fruits_1", producers.get(0)));

        productlist
                .add(new Product(
                        "Apricots",
                        " Bio product",
                        "An apricot is a fruit, or the tree that bears the fruit, of several species in the genus Prunus. Usually, an apricot tree is from the species P. armeniaca, but the species P. brigantina, P. mandshurica, P. mume, P. zhengheensis and P. sibirica are closely related, have similar fruit, and are also called apricots. ",
                        "6",
                        "10",
                        "4",
                        "0",
                        "https://cdn.pixabay.com/photo/2018/05/27/16/19/apricots-3433818__340.jpg",
                        "v_fruits_2", producers.get(0)));

        productlist
                .add(new Product(
                        "Peach",
                        " Frequently bought by locals ",
                        "The peach is a deciduous tree native to the region of Northwest China between the Tarim Basin and the north slopes of the Kunlun Mountains, where it was first domesticated and cultivated. It bears an edible juicy fruit called a peach or a nectarine.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://thewoman.md/wp-content/uploads/2018/07/piersici.jpg",
                        "v_fruits_3", producers.get(0)));

        productlist
                .add(new Product(
                        "Romanian Peach",
                        " Local product of high quality ",
                        "The peach is a deciduous tree native to the region of Northwest China between the Tarim Basin and the north slopes of the Kunlun Mountains, where it was first domesticated and cultivated. It bears an edible juicy fruit called a peach or a nectarine.",
                        "11",
                        "10",
                        "11",
                        "0",
                        "https://s3-media4.fl.yelpcdn.com/bphoto/I06fCgujvVvCOUqWB_TCvw/ls.jpg",
                        "v_fruits_4", producers.get(0)));

        productMap.put("Quality", productlist);

        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getNewcomers() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Ginger",
                        " Newly listed    No restrictions",
                        "Ginger is a flowering plant whose rhizome, ginger root or ginger, is widely used as a spice and a folk medicine.",
                        "6",
                        "12",
                        "6",
                        "0",
                        "https://jurnalulph.ro/images/stories/2013/septembrie/30septembrie/gingerd.jpg",
                        "exoticv_1", producers.get(0)));

        productlist
                .add(new Product(
                        "Turmeric",
                        " This seller is new to the market",
                        "",
                        "7",
                        "12",
                        "7",
                        "0",
                        "https://images-na.ssl-images-amazon.com/images/I/61epg1KzvDL._SX466_.jpg",
                        "exoticv_2", producers.get(0)));

        productlist
                .add(new Product(
                        "Artichockes",
                        " 5 people are looking at this",
                        "",
                        "20",
                        "5",
                        "20",
                        "0",
                        "https://www.oscseeds.com/wp-content/uploads/2018/10/artichokes_VG.jpg",
                        "exoticv_3", producers.get(0)));

        productMap.put("Fresh", productlist);

        productlist = new ArrayList<Product>();


        productlist
                .add(new Product(
                        "Avocado",
                        " High Quality      No restrictions",
                        "Avocados have a unique nutrition profile. They contain lots of fiber and are rich in vitamins and minerals, such as B-vitamins, vitamin K, potassium, copper, vitamin E and vitamin C.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://www.pledgesports.org/wp-content/uploads/2018/01/avocado.jpg",
                        "exoticf_1", producers.get(0)));

        productlist
                .add(new Product(
                        "Banana",
                        " Bio product",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "2",
                        "10",
                        "2",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(0)));

        productlist
                .add(new Product(
                        "Kiwi Fruits",
                        " Best seller",
                        "Kiwi’s beneficial phytonutrients combined with the fantastic lineup of vitamins and minerals kiwi nutrition provides create a delicious, nutrient-dense fruit with an impressive list of health benefits.",
                        "6",
                        "10",
                        "6",
                        "0",
                        "http://naturalpointibiza.com/wp-content/uploads/2015/12/aromat_kiwi.jpg",
                        "exoticf_3", producers.get(0)));

        productlist
                .add(new Product(
                        "Orange",
                        " High user review     Product of the day",
                        "Oranges are a healthy source of fiber, vitamin C, thiamine, folate, and antioxidants. They have multiple health benefits.",
                        "7",
                        "12",
                        "7",
                        "0",
                        "https://capitaltrick.com/wp-content/uploads/2018/12/Orange.jpg",
                        "exoticf_4", producers.get(1)));

        productlist
                .add(new Product(
                        "Lemon",
                        " Best price",
                        "Lemons are a good source of vitamin C and of flavonoids, or antioxidants, which are thought to boost health and wellbeing in several ways.",
                        "8",
                        "10",
                        "8",
                        "0",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8gmE-98eschzi9GOIRq5gOZA27gzb3knJQGMwJYK8zFADfCnqYA",
                        "exoticf_5", producers.get(1)));


        productMap.put("Seasonal", productlist);


        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public ArrayList<Product> getMyShoppingList() {

        ArrayList<Product> productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Avocado",
                        " Best price",
                        "Avocados have a unique nutrition profile. They contain lots of fiber and are rich in vitamins and minerals, such as B-vitamins, vitamin K, potassium, copper, vitamin E and vitamin C.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://www.pledgesports.org/wp-content/uploads/2018/01/avocado.jpg",
                        "exoticf_1", producers.get(1)));

        productlist
                .add(new Product(
                        "Banana",
                        "No ristrictions      High Protein",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "1",
                        "10",
                        "1",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(1)));
        productlist
                .add(new Product(
                        "Kiwi Fruits",
                        " Best seller",
                        "Kiwi’s beneficial phytonutrients combined with the fantastic lineup of vitamins and minerals kiwi nutrition provides create a delicious, nutrient-dense fruit with an impressive list of health benefits.",
                        "6",
                        "10",
                        "6",
                        "0",
                        "http://naturalpointibiza.com/wp-content/uploads/2015/12/aromat_kiwi.jpg",
                        "exoticf_3", producers.get(0)));

        productlist
                .add(new Product(
                        "Orange",
                        " High user review     Product of the day",
                        "Oranges are a healthy source of fiber, vitamin C, thiamine, folate, and antioxidants. They have multiple health benefits.",
                        "7",
                        "12",
                        "7",
                        "0",
                        "https://capitaltrick.com/wp-content/uploads/2018/12/Orange.jpg",
                        "exoticf_4", producers.get(1)));
        return productlist;
    }

    public ArrayList<Product> getFriendsPageList() {

        ArrayList<Product> productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Avocado",
                        " Ciprian and Georgiana bought this today",
                        "Avocados have a unique nutrition profile. They contain lots of fiber and are rich in vitamins and minerals, such as B-vitamins, vitamin K, potassium, copper, vitamin E and vitamin C.",
                        "5",
                        "10",
                        "5",
                        "0",
                        "https://www.pledgesports.org/wp-content/uploads/2018/01/avocado.jpg",
                        "exoticf_1", producers.get(1)));

        productlist
                .add(new Product(
                        "Banana",
                        " 3 Friends bought this - No restrictions",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "1",
                        "10",
                        "1",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(1)));

        productlist
                .add(new Product(
                        "Banana",
                        " Ciprian gave a one star to this product",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "2",
                        "10",
                        "2",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(0)));

        productlist
                .add(new Product(
                        "Kiwi Fruits",
                        " Best seller   5 Friends are looking at this",
                        "Kiwi’s beneficial phytonutrients combined with the fantastic lineup of vitamins and minerals kiwi nutrition provides create a delicious, nutrient-dense fruit with an impressive list of health benefits.",
                        "6",
                        "10",
                        "6",
                        "0",
                        "http://naturalpointibiza.com/wp-content/uploads/2015/12/aromat_kiwi.jpg",
                        "exoticf_3", producers.get(0)));

        productlist
                .add(new Product(
                        "Orange",
                        " New local seller     Three friends bought",
                        "Oranges are a healthy source of fiber, vitamin C, thiamine, folate, and antioxidants. They have multiple health benefits.",
                        "7",
                        "12",
                        "7",
                        "0",
                        "https://capitaltrick.com/wp-content/uploads/2018/12/Orange.jpg",
                        "exoticf_4", producers.get(1)));

        return productlist;
    }

    public ArrayList<Product> getRecommendedProducts() {

        ArrayList<Product> productlist = new ArrayList<Product>();

        productlist
                .add(new Product(
                        "Avocado",
                        " Bio product",
                        "Avocados have a unique nutrition profile. They contain lots of fiber and are rich in vitamins and minerals, such as B-vitamins, vitamin K, potassium, copper, vitamin E and vitamin C.",
                        "5",
                        "10",
                        "4",
                        "0",
                        "https://www.pledgesports.org/wp-content/uploads/2018/01/avocado.jpg",
                        "exoticf_1", producers.get(1)));

        productlist
                .add(new Product(
                        "Banana",
                        " This seller is new to the market ",
                        "Bananas are great super food which provides us with energy, make us feel full and provide our body with essential nutrients and high amount of fiber",
                        "1",
                        "10",
                        "1",
                        "0",
                        "https://parade.com/wp-content/uploads/2014/08/bananas-ftr.jpg",
                        "exoticf_2", producers.get(1)));

        productlist
                .add(new Product(
                        "Kiwi Fruits",
                        " High User Ratings",
                        "Kiwi’s beneficial phytonutrients combined with the fantastic lineup of vitamins and minerals kiwi nutrition provides create a delicious, nutrient-dense fruit with an impressive list of health benefits.",
                        "2",
                        "10",
                        "2",
                        "0",
                        "http://naturalpointibiza.com/wp-content/uploads/2015/12/aromat_kiwi.jpg",
                        "exoticf_3", producers.get(1)));

        return productlist;
    }

    public void getAllProducts(int productCategory) {
        if (productCategory == 0) {
            getRecommendations();
        } else if (productCategory == 1) {
            getNewcomers();
        } else {
            getProductsOfTheWeek();
        }

    }

}
