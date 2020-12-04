package main.day4;

public class Passport {
    private Integer byr=null;//    (Birth Year)
    private Integer iyr=null;//    iyr (Issue Year)
    private Integer eyr=null;//    eyr (Expiration Year)
    private String hgt=null;//    hgt (Height)
    private String hcl=null;//    hcl (Hair Color)
    private String ecl=null;//    ecl (Eye Color)
    private String pid=null;//    pid (Passport ID)
    private Integer cid=null;//    cid (Country ID)

    public Passport(String inputBlock) {
        String[] dataBlock = inputBlock.split(" ");
        if (!(dataBlock.length>9)){
            for(String string:dataBlock){
                match(string);
            }
        }
    }

    private void match(String string) {
        String [] correspondingData=string.split(":");
        switch (correspondingData[0]){
            case "byr":
                byr=checkForByr((correspondingData[1]));
                break;
            case "iyr":
                iyr=checkForIyr((correspondingData[1]));
                break;
            case "eyr":
                eyr=checkForEyr((correspondingData[1]));
                break;
            case "hgt":
                hgt=checkForHgt(correspondingData[1]);
                break;
            case "hcl":
                hcl=checkForHcl(correspondingData[1]);
                break;
            case "ecl":
                ecl=checkForEcl(correspondingData[1]);
                break;
            case "pid":
                pid=checkForPid(correspondingData[1]);
                break;
            case "cid":
                cid=checkForCid(Integer.parseInt(correspondingData[1]));
                break;
        }
    }

    private Integer checkForCid(Integer countryID) {
        return countryID;
    }

    private String checkForPid(String pasportID) {
        if(pasportID.matches("\\d{9}")){
            return pasportID;
        }
        printWasInvalid(pasportID);
        return null;
    }

    private String checkForEcl(String eyeCl) {
        switch (eyeCl){
            case "amb":
            case "blu":
            case "brn":
            case "gry":
            case "grn":
            case "hzl":
            case "oth":
                return eyeCl;
        }
        printWasInvalid(eyeCl);
        return null;
    }

    private String checkForHcl(String hairCl) {
        if (hairCl.contains("#")){
            String hexa=hairCl.replace("#","");
            if(hexa.matches("[(0-9)(a-f)]*")&&hexa.length()==6){
                return hairCl;
            }
        }
        printWasInvalid(hairCl);
        return null;
    }

    private String checkForHgt(String height) {
        if(height.contains("cm")){
            Integer heightInCm=Integer.parseInt(height.replace("cm",""));
            if (150<=heightInCm&&heightInCm<=193){
                return height;
            }
        } else if (height.contains("in")){
            Integer heightInIn=Integer.parseInt(height.replace("in",""));
            if (59<=heightInIn&&heightInIn<=76){
                return height;
            }
        }
        printWasInvalid(height);
        return null;
    }

    private Integer checkForEyr(String expirationYear) {
        if(expirationYear.length()!=4){
            return null;
        }
        Integer input=Integer.parseInt(expirationYear);
        if(2020<=input&&input<=2030){
            return input;
        }
        printWasInvalid(expirationYear.toString());
        return null;
    }

    private Integer checkForIyr(String issueYear) {
        if(issueYear.length()!=4){
            return null;
        }
        Integer input=Integer.parseInt(issueYear);
        if(2010<= input&& input<=2020){
            return input;
        }
        printWasInvalid(issueYear.toString());
        return null;
    }

    private Integer checkForByr(String correspondingDatum) {
        if(correspondingDatum.length()!=4){
            return null;
        }
        Integer input=Integer.parseInt(correspondingDatum);
        if(1920<=input&&input<=2002){
            return input;
        }
        printWasInvalid(correspondingDatum.toString());
        return null;
    }

    public boolean isValid(){
        if(byr==(null)||iyr==(null)||eyr==(null)||hgt==(null)||hcl==(null)||ecl==(null)||pid==(null)){
            printWasInvalid(this.toString());
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Passport{" +
            "byr=" + byr +
            ", iyr=" + iyr +
            ", eyr=" + eyr +
            ", hgt=" + hgt +
            ", hcl=" + hcl +
            ", ecl=" + ecl +
            ", pid=" + pid +
            ", cid=" + cid +
            '}';
    }

    private void printWasInvalid(String argument){
        //System.out.println(argument + " was Invalid!");
    }
}
