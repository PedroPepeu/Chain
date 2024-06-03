package br.com.api.chain.entities;

public enum Cargo {
    
    FRONTEND(1),
    BACKEND(2),
    FULL_STACK(3),
    SCRUM_MASTER(4),
    NONE(5);

    private int code;

    private Cargo(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Cargo valueOf(int code){
        for(Cargo value : Cargo.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de Cargo inválido");
    }
}
