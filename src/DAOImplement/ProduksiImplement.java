package DAOImplement;

import java.util.List;
import model.ProduksiModel;

public interface ProduksiImplement {
    public void insert(ProduksiModel p);
    public void update(ProduksiModel p);
    public void delete(int id);
    public List<ProduksiModel> getAll(ProduksiModel p);
}
