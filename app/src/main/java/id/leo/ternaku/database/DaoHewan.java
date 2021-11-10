package id.leo.ternaku.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoHewan {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataHewan (TabelHewan ... tabelHewans);

    @Query("SELECT * FROM tb_hewan")
    List<TabelHewan> getAllDataHewan();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertDataKandang (TabelKandang ... tabelKandangs);

    @Query("SELECT * FROM tb_kandang ")
    List<TabelKandang> getAllDataKandang();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertDataObat (TabelObat ... tabelObats);

    @Query("SELECT * FROM tb_obat ")
    List<TabelObat> getAllDataObat();
}
