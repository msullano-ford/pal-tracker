package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> database = new HashMap<>();
    long id = 1;

    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry createdTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        database.put(id, createdTimeEntry);
        id++;
        return createdTimeEntry;
    }

    public TimeEntry find(long id) {
        // lookup object in map
        return database.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(database.values());

    }

    public TimeEntry update(long idUpdate, TimeEntry timeEntry) {
      timeEntry.setId(idUpdate);
      database.replace(idUpdate, timeEntry);
      return database.get(idUpdate);

    }

    @Override
    public void delete(long timeEntryId) {
        database.remove(timeEntryId);

    }
}
