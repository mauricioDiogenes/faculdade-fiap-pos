package br.com.fiap.pizza;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MenuActivity extends Activity {

	private List<PizzaEntity> produtosEscolhidos;

	private List pedidos;

	private ProdutosDAO produtosDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		produtosDAO = new ProdutosDAO(this.getApplicationContext());
		pedidos = new ArrayList();
		produtosEscolhidos = new ArrayList<PizzaEntity>();

		LinearLayout layout = (LinearLayout) findViewById(R.id.conteudoSubMenu);

		List<PizzaEntity> p = produtosDAO.getPizzas();
		for (int j = 0; j < p.size(); j++) {
			final ImageButton btn = new ImageButton(getApplicationContext());
			Drawable drawable = getResources().getDrawable(
					getResources().getIdentifier("pizza" + j, "drawable",
							getPackageName()));
			btn.setImageDrawable(drawable);
			btn.setTag(j);
			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addItem((Integer) v.getTag());
				}
			});
			layout.addView(btn);
		}
	}

	private void addItem(int num) {
		pedidos.add(produtosDAO.getPizzaById(String.valueOf(num)));
		System.out.println(" " + num);
	}

}
