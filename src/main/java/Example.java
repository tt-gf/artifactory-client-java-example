import java.util.Scanner;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import org.jfrog.artifactory.client.Artifactory;
import org.jfrog.artifactory.client.ArtifactoryClient;
import org.jfrog.artifactory.client.model.RepoPath;

public class Example {
    public static void main(String[] args) {
        // Disable Artifactory client's debug logs:
        Logger rootLogger = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.setLevel(Level.INFO);

        final String afUrl = prompt("Artifactory URL", "http://artifactory-ci.tomtomgroup.com/artifactory");
        final String afUsername = prompt("User name", "root");
        final String afPassword = prompt("Password", "");

        // Lists all artifacts:
        Artifactory af = ArtifactoryClient.create(afUrl, afUsername, afPassword);
        final long tenYearsInMs = 10 * 365 * 24 * 3600 * 1000;
        for (RepoPath path : af.searches().artifactsCreatedSince(tenYearsInMs).doSearch()) {
            System.out.println(path.getItemPath());
        }
    }

    private static String prompt(String desc, String defaultVal) {
        Scanner input = new Scanner(System.in);
        System.out.format("%s [%s]: ", desc, defaultVal);
        String val = input.nextLine();
        return val.isEmpty() ? defaultVal : val;
    }
}
