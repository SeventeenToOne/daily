package dp.factoryExample;

public abstract  class AbstractHumanFactory {

    abstract   <T extends Human> T createHuman(Class<T> c);
}
