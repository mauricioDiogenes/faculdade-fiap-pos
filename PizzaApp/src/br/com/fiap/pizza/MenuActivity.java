package br.com.fiap.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity {

	private Map<String, PedidoHelper> pedidos;

	private Map<String, List> produtosMap;

	private ProdutosDAO produtosDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		produtosMap = new HashMap();
		produtosMap.put("pizza", new ArrayList<Item>());
		produtosMap.put("bebidas", new ArrayList<Item>());

		
		
		produtosDAO = new ProdutosDAO(this.getApplicationContext());
		pedidos = new HashMap<String, PedidoHelper>();

		final LinearLayout layoutPizza = (LinearLayout) findViewById(R.id.conteudoSubMenuPizza);
		layoutPizza.setVisibility(LinearLayout.INVISIBLE);

		final LinearLayout layoutBebida = (LinearLayout) findViewById(R.id.conteudoSubMenuBebida);
		//layoutBebida.setVisibility(LinearLayout.INVISIBLE);

		buttonActions(layoutPizza, layoutBebida);

		subMenuActions(layoutPizza, "pizza");
		subMenuActions(layoutBebida, "bebidas");

	}

	private void buttonActions(final LinearLayout layoutPizza,
			final LinearLayout layoutBebida) {
		ImageButton pizzaBtn = (ImageButton) findViewById(R.id.pizza);
		pizzaBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				layoutPizza.setVisibility(LinearLayout.VISIBLE);
			}
		});

		ImageButton bebidasBtn = (ImageButton) findViewById(R.id.drinks);
		bebidasBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				layoutBebida.setVisibility(LinearLayout.VISIBLE);
				System.out.println("entrou bebidas");
			}
		});
		
	}

	private void subMenuActions(final LinearLayout layout, String tipo) {
		List<Item> produtosList = produtosMap.get(tipo);
		produtosList = produtosDAO.getProdutos(tipo);

		for (int j = 0; j < produtosList.size(); j++) {
			ImageButton btn = new ImageButton(getApplicationContext());

			LinearLayout linha = new LinearLayout(getApplicationContext());
			linha.setOrientation(LinearLayout.HORIZONTAL);
			linha.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT));

			Drawable drawable = getResources().getDrawable(
					getResources().getIdentifier(tipo + j, "drawable",
							getPackageName()));
			btn.setImageDrawable(drawable);
			btn.setTag(R.string.cont, j);
			btn.setTag(R.string.tipo, tipo);
			TextView nome = new TextView(getApplicationContext());
			nome.setText(produtosList.get(j).getNome());
			TextView conteudo = new TextView(getApplicationContext());
			conteudo.setText(produtosList.get(j).getConteudo());
			conteudo.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);
			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addItem((Integer) v.getTag(R.string.cont), (String) v.getTag(R.string.tipo));
				}
			});
			linha.addView(btn);
			linha.addView(conteudo);
			layout.addView(nome);
			layout.addView(linha);
		}
	}

	private void addItem(int num, String tipo) {
		if (pedidos.get(tipo + num) != null) {
			PedidoHelper p = pedidos.get(tipo + num);
			pedidos.remove(tipo + num);
			p.addCount();
			pedidos.put(tipo + num, p);
		} else {
			pedidos.put(tipo + num, new PedidoHelper(1, produtosMap.get(tipo).get(num)));
		}

		Toast toast = Toast.makeText(getApplicationContext(),
				"Produto adicionado", 1000);
		toast.show();
		/*
		 * for(int j=0;j<pedidos.size();j++){ PedidoHelper p = (PedidoHelper)
		 * pedidos.values().toArray()[j]; System.out.println(p.getCount()); }
		 */
	}

}
