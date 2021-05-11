package edu.coursework.enterprises.data;

/*
    @author:    Bogdan
    @project:    Zoo
    @class:    FakeData
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.model.Plane;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeData {

    private List<Civil> civilList = new ArrayList<>(
            Arrays.asList(
                    new Civil("1", true, 200, true),
                    new Civil("2", true, 150, false),
                    new Civil("3", false, 300, true),
                    new Civil("4", false, 250, true),
                    new Civil("5", true, 200, false),
                    new Civil("6", true, 250, true),
                    new Civil("7", false, 300, false),
                    new Civil("8", true, 300, false),
                    new Civil("9", false, 150, true),
                    new Civil("10", true, 250, true)));

    private List<Plane> planeList = new ArrayList<>(
            Arrays.asList(
                    new Plane("1", "SkyJet", "VipPlus", civilList.get(0), 2019,
                            2, 60 , 20.43, 7.66, 30.07, 10240),
                    new Plane("2", "EconomLux", "250-D", civilList.get(1), 2018,
                            2, 70 , 20.43, 7.66, 32.07, 11240),
                    new Plane("3", "Business", "300F", civilList.get(2), 2010,
                            2, 90 , 20.43, 7.66, 42.07, 9240),
                    new Plane("4", "BigTravel", "100K", civilList.get(3), 2008,
                            2, 90 , 20.43, 7.66, 42.07, 14240),
                    new Plane("5", "LuxComfort", "Comfort Plus", civilList.get(4), 2020,
                            2, 50 , 20.43, 7.66, 42.07, 14240),
                    new Plane("6", "Luxt", "ComfortP", civilList.get(5), 2020,
                            2, 50 , 20.43, 7.66, 42.07, 14240),
                    new Plane("7", "SkyRun", "Plus", civilList.get(6), 2019,
                            2, 90 , 30.43, 10.06, 40.07, 16240),
                    new Plane("8", "Fun", "Vips", civilList.get(7), 2015,
                            2, 40 , 22.43, 7.66, 25.07, 8240),
                    new Plane("9", "LongD", "S", civilList.get(8), 2019,
                            2, 60 , 20.43, 7.66, 30.07, 5240),
                    new Plane("10", "BigL", "T", civilList.get(9), 2019,
                            2, 70 , 10.43, 7.66, 15.07, 6240)));

    public List<Civil> getCivilList() {
        return civilList;
    }

    public void setCivilList(List<Civil> civilList) {
        this.civilList = civilList;
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<Plane> plane) {
        this.planeList = planeList;
    }
}
