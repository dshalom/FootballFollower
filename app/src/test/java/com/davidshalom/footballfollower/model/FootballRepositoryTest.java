package com.davidshalom.footballfollower.model;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.davidshalom.footballfollower.model.db.entities.Competition;
import com.davidshalom.footballfollower.model.db.entities.CompetitionDao;
import com.davidshalom.footballfollower.model.services.FootballService;
import com.davidshalom.footballfollower.model.services.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)

public class FootballRepositoryTest {
    private Context context = Mockito.mock(Context.class);
    private CompetitionDao competitionsDao = Mockito.mock(CompetitionDao.class);
    private FootballService footballService = Mockito.mock(FootballService.class);
    private Call<List<Competition>> mockCall = Mockito.mock(Call.class);

    private FootballRepository sut;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        Mockito.doReturn(mockCall).when(footballService).getCompetitions();
        sut = new FootballRepository(context, footballService, competitionsDao);
    }

    @Test
    public void getCompetitions() {

        final Response<List<Competition>> response = getTwoCompetitions();
        //given
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback<List<Competition>> callback = invocation.getArgument(0);
                callback.onResponse(null, response);
                return null;
            }
        }).when(mockCall).enqueue(any(Callback.class));

        //when
        LiveData<Resource<List<Competition>>> result = sut.getCompetitions();

        //expect
        //assertEquals(2, result.getValue().getData().size());
        verify(competitionsDao).insertAll(response.body());

        //test db os called

    }

    private Response<List<Competition>> getTwoCompetitions() {
        List<Competition> competitions = new ArrayList<>();
        Competition competition = new Competition(5, "c1");
        Competition competition2 = new Competition(5, "c2");
        competitions.add(competition);
        competitions.add(competition2);
        return Response.success(competitions);
    }

}
