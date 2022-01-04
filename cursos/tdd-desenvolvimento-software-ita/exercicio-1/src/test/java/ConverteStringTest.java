import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ConverteStringTest {

    @Test
    public void retornaNomeMinusculo(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("nome");
        Assertions.assertEquals(Arrays.asList("nome"), lista);
    }

    @Test
    public void retornaNomeCamelCase(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("Nome");
        Assertions.assertEquals(Arrays.asList("nome"), lista);
    }

    @Test
    public void retornaNomeCompostoCom1CasoDeCamelCase(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("nomeComposto");
        Assertions.assertEquals(Arrays.asList("nome", "composto"), lista);
    }

    @Test
    public void retornaNomeCompostoCom2CasosDeCamelCase(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("NomeComposto");
        Assertions.assertEquals(Arrays.asList("nome", "composto"), lista);
    }

    @Test
    public void retornaCPF(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("CPF");
        Assertions.assertEquals(Arrays.asList("CPF"), lista);
    }

    @Test
    public void retornaNumeroECPF(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("numeroCPF");
        Assertions.assertEquals(Arrays.asList("numero", "CPF"), lista);
    }

    @Test
    public void retornaNumeroCPFEContribuinte(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("numeroCPFContribuinte");
        Assertions.assertEquals(Arrays.asList("numero", "CPF", "contribuinte"), lista);
    }

    @Test
    public void retornaRecupera10Primeiros(){
        IConverteString converteString = new ConverteString();
        List<String> lista = converteString.converterCamelCase("recupera10Primeiros");
        Assertions.assertEquals(Arrays.asList("recupera", "10", "primeiros"), lista);
    }

    @Test
    public void retornaErroPoisComecaComNumero(){
        IConverteString converteString = new ConverteString();
        Assertions.assertThrows(InvalidStringException.class, () -> converteString.converterCamelCase("10Primeiros"));
    }

    @Test
    public void retornaErroPoisHaCaracteresEspeciais(){
        IConverteString converteString = new ConverteString();
        Assertions.assertThrows(InvalidStringException.class, () -> converteString.converterCamelCase("nome#Composto"));
    }
}
