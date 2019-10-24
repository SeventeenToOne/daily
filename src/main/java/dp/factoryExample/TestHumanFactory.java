package dp.factoryExample;

public class TestHumanFactory {
    public static void main(String[] args){
        HumanFactory humanFactory = new HumanFactory();
        Human human1 = humanFactory.createHuman(BlackHuman.class);
        Human human2 = humanFactory.createHuman(WhiteHuman.class);
        Human human3 = humanFactory.createHuman(YellowHuman.class);

        human1.say();human2.say();human3.say();
    }
}
