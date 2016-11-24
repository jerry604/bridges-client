package com.jtsai.burningbridges.local;

/**
 * Created by Jerry Tsai on 2016-11-11.
 */

public class LocalGameLogic {
    private static LocalGameLogic mInstance = null;
    private static final int DEFAULT_NUM_BARRELS = 6;
    private int numBarrels = 0;
    private int targetNum = 0;

    private LocalGameLogic() {}

    public static LocalGameLogic getInstance() {
        if (mInstance == null) {
            mInstance = new LocalGameLogic();
        }
        return mInstance;
    }

    public void startLocalGame() {
        numBarrels = DEFAULT_NUM_BARRELS;
        targetNum = fetchRandomNum(numBarrels);
    }

    public boolean pullTrigger() {
        int shotNum = fetchRandomNum(numBarrels);
        boolean isShot = false;

        if (shotNum != targetNum) {
            numBarrels = numBarrels - 1;
            targetNum = fetchRandomNum(numBarrels);
            isShot = false;
        } else {
            isShot = true;
        }

        return isShot;
    }

    private int fetchRandomNum(int maxNum) {
        return (int) Math.ceil(Math.random() * maxNum);
    }
}
