package com.dh.medicamentos.dao;

public interface IDao <T>{

    /* Con genéricos, no especificamos el tipo de objeto (Medicamento, por ejemplo)
     * sino que esa 'T' que definimos entre diamantes junto a la interfaz
     * es la que hace la magia necesaria para trabajar con el tipo que le definamos
     * al usar la interfaz (ver en el Main, luego en el Service y, finalmente,
     * al momento de que la clase de implementación -MedicamentoDaoH2- define el implements)
    */
    public T guardar(T t);
    public T buscar(Integer id);
}
