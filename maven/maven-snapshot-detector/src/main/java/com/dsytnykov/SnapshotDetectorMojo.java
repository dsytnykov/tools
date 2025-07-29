package com.dsytnykov;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "check-snapshots", defaultPhase = LifecyclePhase.VALIDATE)
public class SnapshotDetectorMojo extends AbstractMojo {
    
    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;
    
    @Parameter(property = "snapshotPostfix", defaultValue = "-SNAPSHOT")
    private String snapshotPostfix;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencies = project.getDependencies();
        List<Dependency> snapshotDependencies = dependencies.stream()
                .filter(dependency -> dependency.getVersion().endsWith(snapshotPostfix))
                .toList();
        
        if (!snapshotDependencies.isEmpty()) {
            StringBuilder messageBuilder = new StringBuilder("Found snapshot dependencies:\n");
            snapshotDependencies.forEach(dependency -> {
                messageBuilder.append(String.format("  %s:%s has version %s\n",
                        dependency.getGroupId(),
                        dependency.getArtifactId(),
                        dependency.getVersion()));
            });
            throw new MojoFailureException(messageBuilder.toString());
        } else {
            getLog().info("No snapshot dependencies found. Your project is ready for release!");
        }
    }

    protected void setProject(MavenProject project) {
        this.project = project;
    }
}
