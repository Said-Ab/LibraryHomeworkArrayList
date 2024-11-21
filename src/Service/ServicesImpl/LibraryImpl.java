package Service.ServicesImpl;

import database.Database;
import models.Library;
import Service.LibraryService;

public class LibraryImpl implements LibraryService {
    @Override
    public void saveLibrary(Library library) {
        Database.libraries.add(library);

    }

    @Override
    public Library getLibrary(long id) {
        for (Library library:Database.libraries){
            if(library.getId()==id){
                return library;
            }
        }
        return null;
    }

    @Override
    public void updateLibrary(Long id, Library library) {
        for (Library l:Database.libraries){
            if(l.getId()==id){
                l.setAddress(library.getAddress());
                l.setName(library.getName());

            }
        }

    }

    @Override
    public String deleteLibrary(Long id) {
        Library library=getLibrary(id);
        Database.libraries.remove(library);
        return "success deleted";
    }
}
