import br.com.alura.tdd.service.BonusService;
import br.com.alura.tdd.service.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;


public class BonusServiceTest {

    @Test
    public void bonusDeverisaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Iasmim", LocalDate.now(), new BigDecimal("25000"))));

    }

    @Test
    public void bonusDeverisaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Iasmim", LocalDate.now(), new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeversiaSer10PorCentoParaSalariodeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Iasmim", LocalDate.now(), new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
