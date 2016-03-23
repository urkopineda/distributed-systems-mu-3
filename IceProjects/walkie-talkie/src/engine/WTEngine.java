package engine;

import Ice.Current;
import walkietalkie._WTDisp;

/**
 * Created by urko on 22/03/16.
 */
public class WTEngine extends _WTDisp {

    @Override
    public void pushMessage(String message, Current __current) {
        System.out.println(message);
    }

}
