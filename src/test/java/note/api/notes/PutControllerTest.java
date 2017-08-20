package note.api.notes;

import note.NoteUtil;
import note.application.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PutControllerTest {

    private static final String ID = "3";
    private static final String TITLE = "TITLE";
    private static final String BODY = "BODY";

    @InjectMocks
    private PutController sut;

    @Mock
    private NoteService serviceMock;

    @Test
    public void put_Update() {
        PutForm form = new PutForm(ID, TITLE, BODY);

        ResponseEntity<Void> ret = sut.put(form);

        verify(serviceMock).update(Integer.valueOf(ID), TITLE, BODY);
        assertThat(ret.getStatusCode(), is(HttpStatus.NO_CONTENT));
    }

    @Test
    public void put_Create() {
        PutForm form = new PutForm(null, TITLE, BODY);
        doReturn(NoteUtil.createNote(Integer.valueOf(ID), TITLE, BODY, null, null))
                .when(serviceMock).add(TITLE, BODY);

        ResponseEntity<Void> ret = sut.put(form);

        verify(serviceMock).add(TITLE, BODY);
        assertThat(ret.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(ret.getHeaders().getLocation(), is(URI.create("http://localhost:8080/notes/" + ID)));

    }
}