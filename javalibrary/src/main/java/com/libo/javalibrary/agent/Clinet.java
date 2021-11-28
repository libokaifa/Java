package com.libo.javalibrary.agent;

/**
 * /**
 *
 * @Author libo
 * @create 2/26/21 3:56 PM
 * @describe:
 */
class Clinet  implements  Meassage{
  Meassage meassage;
    int i=1;

    public Clinet(Meassage meassage) {
        this.meassage = meassage;
    }

    @Override
    public void wash() {

        i++;
    }
}
