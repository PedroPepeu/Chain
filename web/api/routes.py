from flask import render_template, flash, redirect, url_for
from api.index import app 
from api.forms import LoginForm


@app.errorhandler(404)
def not_found(e):
    return render_template('errors/404.html')

@app.route('/', methods=['GET'])
@app.route('/index', methods=['GET'])
def index():
    return render_template('index.html')


@app.route('/login', methods=['GET', 'POST'])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        flash('Login requested for user {}, remember_me={}'.format(
            form.username.data, form.remember_me.data))
        return redirect(url_for('index'))
    return render_template('login.html', title='Sign In', form=form)

@app.route('/projects', methods=['GET', 'POST'])
def projects():
    return render_template('projects.html')