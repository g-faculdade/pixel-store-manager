package util;

import java.io.*;

public class Serializador {

    public static void salvar(String arquivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(objeto);
        } catch (Exception _) {
        }
    }

    public static Object carregar(String arquivo) {
        File file = new File(arquivo);
        if (!file.exists()) return null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}