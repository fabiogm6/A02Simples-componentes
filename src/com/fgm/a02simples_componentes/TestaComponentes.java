package com.fgm.a02simples_componentes;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class TestaComponentes extends ActionBarActivity {

	public String mListaItemSelecionado;
	final Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testa_componentes);
			
		//ids
		final EditText campo = (EditText) findViewById(R.id.campoNome);
		final RadioGroup rg = (RadioGroup) findViewById(R.id.radioopcoes);
		final Spinner sp = (Spinner) findViewById(R.id.opcoesspinner);
		final ListView ls = (ListView) findViewById(R.id.lista);
		//lista: campo para mostrar o q foi clicado na lista
		final TextView textoselecionadonalista = (TextView) findViewById(R.id.textViewlista);
		//texto q mostra o q foi preenchido
		final TextView texto = (TextView) findViewById(R.id.textView1);
		//
		final Button botao = (Button) findViewById(R.id.button1);

		// popula o spinner
		String[] percentual = {"Op1","Op2","Op3"};
		ArrayAdapter<String> percentualAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, percentual);
		sp.setAdapter(percentualAdapter);		

		//popula a lista
		String[] contatos = {"Paulo","Sergio","Ana","Contato1","Contato2","Contato3","Contato4","Contato5"};
		ArrayAdapter<String> contatoslAdapter =	new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);
		ls.setAdapter(contatoslAdapter);			
		
		//acao do item selecionado na lista
		ls.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView contatoslAdapter, View view, int posicao, long idDoObjeto)
			{
				mListaItemSelecionado = "Lista pos: "+posicao + " - id: "+idDoObjeto;
				textoselecionadonalista.setText(mListaItemSelecionado);
				
				//alerta modal
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage("vc selecionou: " + mListaItemSelecionado);
				builder.setNeutralButton("Ok", null);
				AlertDialog dialog = builder.create();
				dialog.setTitle("Teste de msg alerta");
				dialog.show();
				
			}
		});
		
		//acao do botao
		botao.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stubf
				// pega o Radio
				int opn = rg.getCheckedRadioButtonId();
				String ops;
				if (opn == R.id.opcao1) {ops="Opcao 1";}
					//else if (opn == R.id.opcao2) {ops="Opcao 2";}
					else {ops="Opcao 3";}
				//pega o Spinner
				int opcaoSelecionada = sp.getSelectedItemPosition();
				//
				texto.setText("Digitado: " + campo.getText().toString() + " - RadioSelecionado: " + ops +
						" - SpinnerSelecionado: " + opcaoSelecionada + " " +
						mListaItemSelecionado)	;
				campo.setText("");
			}
		}	);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.testa_componentes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
