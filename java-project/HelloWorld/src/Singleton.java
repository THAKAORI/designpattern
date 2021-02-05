class RegisterNote{
    private static RegisterNote registerNote = new RegisterNote();
    private RegisterNote(){}
    public static RegisterNote getInstance(){
        return registerNote;
    }
}

public class Singleton {
    public static void main(String[] args) throws Exception {
        RegisterNote note = RegisterNote.getInstance();
    }
}

/*クラスのインスタンスが1つしかないことを保証する*/