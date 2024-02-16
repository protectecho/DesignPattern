package pattern.decorate;

public class DecorateUse {
    public static void main(String[] args) {
        //phone one=new MaxMiPhone(new MiPhone());
        phone two=new MaxMiPhonePlus(new MaxMiPhone(new MiPhone()));
        two.photo();
    }
}

interface phone{
    void photo();
}

class MiPhone implements phone{
    @Override
    public void photo(){
        System.out.println("拍照");
    }
}

//采用抽象类可以让多个功能组合在一起,就比如让MaxMiPhone和MaxMiPhonePlus增强MiPhone的功能
abstract class decoratePhone implements phone{
    phone phoneTest;

    public decoratePhone(phone phoneTest) {
        this.phoneTest = phoneTest;
    }
}

class MaxMiPhone extends decoratePhone{
    public MaxMiPhone(phone phoneTest) {
        super(phoneTest);
    }

    @Override
    public void photo() {
        System.out.println("美颜");
        phoneTest.photo();
    }
}

class MaxMiPhonePlus extends decoratePhone{
    public MaxMiPhonePlus(phone phoneTest){
        super(phoneTest);
    }
    @Override
    public void photo(){
        System.out.println("滤镜");
        phoneTest.photo();
    }
}
