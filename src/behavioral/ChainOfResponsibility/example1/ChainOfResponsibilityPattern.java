package behavioral.ChainOfResponsibility.example1;

/**
 *
 */
public class ChainOfResponsibilityPattern {

}

interface PipelineStage {
    public void runStage();
}

class DataExtractor implements PipelineStage {

    @Override
    public void runStage() {

    }
}