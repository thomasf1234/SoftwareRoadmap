package com.company;

import com.company.io.ArrayListIO;
import com.company.models.Software;
import com.company.models.SoftwareVersion;
import com.company.utils.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    private static String dataStoreFilePath = "db/data/Softwares.bin";

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            createData();
            readAndPrintData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void createData() throws IOException, ParseException {
        ArrayList<SoftwareVersion> postgresqlSoftwareVersions = new ArrayList<>();
        postgresqlSoftwareVersions.add(new SoftwareVersion("9.4", DateUtils.parseDate("2014-12-01"), DateUtils.parseDate("2019-12-01")));
        postgresqlSoftwareVersions.add(new SoftwareVersion("9.5", DateUtils.parseDate("2016-01-01"), DateUtils.parseDate("2021-01-01")));
        postgresqlSoftwareVersions.add(new SoftwareVersion("9.6", DateUtils.parseDate("2016-09-01"), DateUtils.parseDate("2021-09-01")));
        postgresqlSoftwareVersions.add(new SoftwareVersion("10", DateUtils.parseDate("2017-10-01"), DateUtils.parseDate("2022-10-01")));

        Software postgresql = new Software("Postgresql", postgresqlSoftwareVersions);

        ArrayList<SoftwareVersion> ubuntuSoftwareVersions = new ArrayList<>();
        ubuntuSoftwareVersions.add(new SoftwareVersion("12.04", DateUtils.parseDate("2012-04-26"), DateUtils.parseDate("2017-04-28")));
        ubuntuSoftwareVersions.add(new SoftwareVersion("14.04", DateUtils.parseDate("2014-04-17"), DateUtils.parseDate("2019-04-01")));
        ubuntuSoftwareVersions.add(new SoftwareVersion("16.04", DateUtils.parseDate("2016-04-21"), DateUtils.parseDate("2021-04-01")));

        Software ubuntu = new Software("Ubuntu Server LTS", ubuntuSoftwareVersions);


        ArrayList<Software> arrayList = new ArrayList<>();
        arrayList.add(postgresql);
        arrayList.add(ubuntu);
        ArrayListIO.write(arrayList, dataStoreFilePath);
    }

    public static void readAndPrintData() throws IOException, ClassNotFoundException {
        ArrayList arrayList = ArrayListIO.read(dataStoreFilePath);

        for (Object element : arrayList) {
            Software software = (Software) element;

            ArrayList<SoftwareVersion> softwareVersions = software.getVersions();

            for (SoftwareVersion softwareVersion : softwareVersions) {
                String formattedEOLDate = new SimpleDateFormat("MM/yyyy").format(softwareVersion.getEndOfLifeDate());
                System.out.println(String.format("%s %s EOL: %s", software.getName(), softwareVersion.getName(), formattedEOLDate));
            }
        }
    }
}
