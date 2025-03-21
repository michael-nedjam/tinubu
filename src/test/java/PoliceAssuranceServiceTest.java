import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.Optional;

import com.tinubu.application.model.PoliceAssurance;
import com.tinubu.application.repository.PoliceAssuranceRepository;
import com.tinubu.application.service.PoliceAssuranceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PoliceAssuranceServiceTest {

    @Mock
    private PoliceAssuranceRepository repository;

    @InjectMocks
    private PoliceAssuranceService policeAssuranceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListerPolices() {
        List<PoliceAssurance> mockPolices = Arrays.asList(new PoliceAssurance(), new PoliceAssurance());
        when(repository.findAll()).thenReturn(mockPolices);

        List<PoliceAssurance> result = policeAssuranceService.listerPolices();

        assertEquals(mockPolices, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreerPolice() {
        PoliceAssurance mockPolice = new PoliceAssurance();
        mockPolice.setId(1);
        when(repository.save(any(PoliceAssurance.class))).thenReturn(mockPolice);

        PoliceAssurance result = policeAssuranceService.creerPolice("Nom", PoliceAssurance.Status.ACTIVE, new Date(), new Date());

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(repository, times(1)).save(any(PoliceAssurance.class));
    }

    @Test
    public void testLirePolice() {
        PoliceAssurance mockPolice = new PoliceAssurance();
        mockPolice.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(mockPolice));

        Optional<PoliceAssurance> result = policeAssuranceService.lirePolice(1);

        assertTrue(result.isPresent());
        assertEquals(mockPolice, result.get());
        verify(repository, times(1)).findById(1);
    }

    @Test
    public void testEditerPolice() {
        PoliceAssurance mockPolice = new PoliceAssurance();
        mockPolice.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(mockPolice));
        when(repository.save(any(PoliceAssurance.class))).thenReturn(mockPolice);

        PoliceAssurance result = policeAssuranceService.editerPolice(1, "Nouveau Nom", PoliceAssurance.Status.INACTIVE, new Date(), new Date());

        assertNotNull(result);
        assertEquals("Nouveau Nom", result.getNom());
        assertEquals(PoliceAssurance.Status.INACTIVE, result.getStatus());
        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).save(any(PoliceAssurance.class));
    }
}
