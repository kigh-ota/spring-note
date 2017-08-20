package note.application;

import note.domain.model.NoteRepository;
import note.domain.model.note.Note;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    private static final Integer ID = 2;
    private static final String TITLE = "TITLE";
    private static final String BODY = "BODY";

    @InjectMocks
    private NoteService sut;

    @Mock
    private NoteRepository noteRepositoryMock;

    @Captor
    private ArgumentCaptor<Note> captor;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void get_ReturnsNull() {
        assertThat(sut.get(null), is(nullValue()));
    }

    @Test
    public void get() {
        sut.get(ID);
        verify(noteRepositoryMock).findOne(ID);
    }

    @Test
    public void getAll() {
        sut.getAll();
        verify(noteRepositoryMock).findAll();
    }

    @Test
    public void add() {
        sut.add(TITLE, BODY);
        verify(noteRepositoryMock).save(captor.capture());
        Note note = captor.getValue();
        assertThat(note.getId(), is(nullValue()));
        assertThat(note.getTitle().getTitle(), is(TITLE));
        assertThat(note.getBody().getBody(), is(BODY));
    }

    @Test
    public void update() {
        Note note = new Note();
        note.setId(ID);
        note.setTitle(TITLE).setBody(BODY);
        doReturn(note).when(noteRepositoryMock).findOne(ID);

        sut.update(ID, TITLE + "2", BODY + "2");

        verify(noteRepositoryMock).save(captor.capture());

        Note note2 = captor.getValue();
        assertThat(note2.getId(), is(ID));
        assertThat(note2.getTitle().getTitle(), is(TITLE + "2"));
        assertThat(note2.getBody().getBody(), is(BODY + "2"));

    }

    @Test(expected = RuntimeException.class)
    public void update_NoteNotFound() {
        doReturn(null).when(noteRepositoryMock).findOne(anyInt());
        sut.update(ID, TITLE, BODY);
    }

}