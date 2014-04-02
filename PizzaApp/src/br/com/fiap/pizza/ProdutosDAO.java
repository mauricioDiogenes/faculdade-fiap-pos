package br.com.fiap.pizza;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProdutosDAO extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "PRODUTOS";

	public ProdutosDAO(Context context) {
		super(context, DATABASE_NAME, null, 1);
		cargaInicial();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	public void cargaInicial() {
		SQLiteDatabase db = this.getWritableDatabase();
		String drop = "DROP TABLE IF EXISTS PRODUTOS";
		db.execSQL(drop);
		String criaBase = "CREATE TABLE PRODUTOS (id, tipo, nome, conteudo, valor)";
		db.execSQL(criaBase);

		addPizza(db, 1, "Peperone", "Queijo, Peperone", 30D);
		addPizza(db, 2, "Mussarela", "Queijo, Molho", 25D);
		addPizza(db, 3, "Frango", "Frango, Queijo", 35D);
		addPizza(db, 4, "Portuguesa", "Queijo, Tomate, Calabresa", 40D);
		addPizza(db, 5, "Quatro queijos",
				"mozzarella, gorg., parmesão e Catupiry", 45D);
	}

	public void addPizza(SQLiteDatabase db, Integer id, String nome,
			String conteudo, Double preco) {
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("tipo", "pizza");
		values.put("nome", nome);
		values.put("conteudo", conteudo);
		values.put("valor", preco);
		db.insert("PRODUTOS", null, values);
	}

	public List<PizzaEntity> getPizzas() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query("PRODUTOS", new String[] { "id", "tipo",
				"nome", "conteudo", "valor" }, " tipo = ?",
				new String[] { "pizza" }, null, null, null, null);

		List<PizzaEntity> pizzaList = null;

		if (cursor != null) {
			pizzaList = new ArrayList<PizzaEntity>();
			while (cursor.moveToNext()) {
				PizzaEntity p = new PizzaEntity();
				p.setId(cursor.getInt(0));
				p.setNome(cursor.getString(2));
				p.setConteudo(cursor.getString(3));
				p.setValor(cursor.getDouble(4));
				pizzaList.add(p);
			}
		}
		return pizzaList;
	}

	public PizzaEntity getPizzaById(String id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query("PRODUTOS", new String[] { "id", "tipo",
				"nome", "conteudo", "valor" }, " id = ?", new String[] { id },
				null, null, null, null);
		PizzaEntity p = new PizzaEntity();
		p.setId(cursor.getInt(0));
		p.setNome(cursor.getString(2));
		p.setConteudo(cursor.getString(3));
		p.setValor(cursor.getDouble(4));

		return p;

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}