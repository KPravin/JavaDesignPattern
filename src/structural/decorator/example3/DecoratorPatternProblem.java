package structural.decorator.example3;

/**
 *
 */
public class DecoratorPatternProblem {
    public static void main(String[] args) {

        IData data = new IData();
        IAlgorithm algo1 = new TwoDObjectDetectionAlgorithm();
        algo1.applyAlgorithm(data);

        IAlgorithm algo2 = new ImageAnonymizationAlgorithm();
        algo2.applyAlgorithm(data);

        /////////////////////////////////////////////////////////////////
        IAlgorithm algo3 = new ImageAnonymizationAlgorithmAsyncDecorator(new ImageAnonymizationAlgorithm());
        algo3.applyAlgorithm(data);


    }
}

class IData {
    private Object data;
}

interface IAlgorithm {
    public String applyAlgorithm(IData data);
}

abstract class IAlgorithmAsyncDecorator implements IAlgorithm {
    protected IAlgorithm algorithmAsyncDecorator;

    public IAlgorithmAsyncDecorator(IAlgorithm algorithmAsyncDecorator) {
        this.algorithmAsyncDecorator = algorithmAsyncDecorator;
    }

    @Override
    public String applyAlgorithm(IData data) {
        algorithmAsyncDecorator.applyAlgorithm(data);
        return "Return from IAlgorithmAsyncDecorator";
    }
}

class TwoDObjectDetectionAlgorithm implements IAlgorithm {
    @Override
    public String applyAlgorithm(IData data) {
        System.out.println("TwoDObjectDetectionAlgorithm applying on data...result saved in s3");
        return "Return from TwoDObjectDetectionAlgorithm";
    }
}

class ImageAnonymizationAlgorithm implements IAlgorithm {

    @Override
    public String applyAlgorithm(IData data) {
        System.out.println("ImageAnonymizationAlgorithm applying on data...result saved in s3");
        return "Return from ImageAnonymizationAlgorithm";
    }
}

class ImageAnonymizationAlgorithmAsyncDecorator extends IAlgorithmAsyncDecorator {

    public ImageAnonymizationAlgorithmAsyncDecorator(IAlgorithm algorithmAsyncDecorator) {
        super(algorithmAsyncDecorator);
    }

    @Override
    public String applyAlgorithm(IData data) {

        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ImageAnonymizationAlgorithmAsyncDecorator applying on data...result saved in s3");
        };
        Thread t = new Thread(r);
        t.start();

        return "Return from ImageAnonymizationAlgorithmAsyncDecorator";
    }
}

