package Cooper.Jmockit.Jmockit_easy_example;

public class Constructor {
    private String memberId;

    public Constructor(String memberId) {
        this.memberId = memberId;
    }

    public String getRealName() {
        return "real_" + this.memberId;
    }
}
