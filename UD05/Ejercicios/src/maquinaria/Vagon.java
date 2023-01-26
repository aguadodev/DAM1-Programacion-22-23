package maquinaria;

class Vagon {
    private int num;
    private int cargaMaxima;
    private int cargaActual;
    private String tipoMercancia;
    
    public Vagon(int num, int cargaMaxima, int cargaActual, String tipoMercancia) {
        this.num = num;
        this.cargaMaxima = cargaMaxima < 0? 0 : cargaMaxima;
        setCargaActual(cargaActual);
        /*
        if (cargaActual > cargaMaxima)
            this.cargaActual = cargaMaxima;
        else if (cargaActual < 0)
            this.cargaActual = 0;
        else 
            this.cargaActual = cargaActual;*/
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }

    public Vagon(int num, int cargaMaxima, int cargaActual) {
        this(num, cargaMaxima, cargaActual, null);
    }

    public Vagon(int num, int cargaMaxima) {
        this(num, cargaMaxima, 0, null);
    }


    @Override
    public String toString() {
        return "Vagon [num=" + num + ", cargaMaxima=" + cargaMaxima + ", cargaActual=" + cargaActual
                + ", tipoMercancia=" + tipoMercancia + "]";
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public int getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(int cargaActual) {
        if (cargaActual > cargaMaxima)
            this.cargaActual = cargaMaxima;
        else if (cargaActual < 0)
            this.cargaActual = 0;
        else 
            this.cargaActual = cargaActual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    

}
