package io.github.vdaburon.jmeterplugins.elasticapm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ElasticApmIntegrateInstaller {
    public static void main(String[] argv) throws IOException {
        writeOut("elastic-apm-integrate.cmd", false);
        writeOut("elastic-apm-integrate.sh", true);
    }

    private static void writeOut(String resName, boolean executable) throws IOException {
        resName = "/io/github/vdaburon/jmeterplugins/elasticapm/" + resName;
        File self = new File(ElasticApmIntegrateInstaller.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        File src = new File(resName);
        String home = self.getParentFile().getParentFile().getParent();
        File dest = new File(home + File.separator + "bin" + File.separator + src.getName());

        InputStream is = ElasticApmIntegrateInstaller.class.getResourceAsStream(resName);
        Files.copy(is, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        dest.setExecutable(executable);
    }
}
