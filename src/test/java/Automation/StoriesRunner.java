package Automation;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ScanningStepsFactory;

import java.util.Arrays;
import java.util.List;


public class StoriesRunner extends JUnitStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
    }

    @Override
    protected List<String> storyPaths() {
//        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(getClass()), "stories/**/*.story", "**parametr**");
//        return Arrays.asList("stories/simple_math.story", "stories/two_addition_math.story", "stories/parametrized-math.story");
        return Arrays.asList("stories/crud.story");
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
//        return new InstanceStepsFactory(configuration(), new MathSteps());
        return new ScanningStepsFactory(configuration(), "Automation.steps");
    }
}