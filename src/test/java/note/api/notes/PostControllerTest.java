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
public class PostControllerTest {

    @InjectMocks
    private PostController sut;

    @Mock
    private NoteService noteServiceMock;

    @Test
    public void post() {
        final Integer ID = 3;
        final String TITLE = "TITLE";
        final String BODY = "BODY";
        PostForm form = new PostForm(TITLE, BODY);
        doReturn(NoteUtil.createNote(ID, TITLE, BODY, null, null))
                .when(noteServiceMock).add(TITLE, BODY);

        ResponseEntity<Void> actual = sut.post(form);

        verify(noteServiceMock).add(TITLE, BODY);
        assertThat(actual.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(actual.getHeaders().getLocation(), is(URI.create("http://localhost:8080/notes/" + ID.toString())));
    }

}