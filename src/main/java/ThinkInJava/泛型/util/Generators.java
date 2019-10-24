package ThinkInJava.泛型.util;

import java.util.Collection;
/*
*
* p364
* @author wxq
* @date 2018-4-20
* */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++){
            coll.add(gen.next());
        }
        return coll;
    }

}
