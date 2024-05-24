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
    return render_template('login.html')

@app.route('/cadastro', methods=['GET', 'POST'])
def cadastro():
    return render_template('cadastro.html')

@app.route('/projects', methods=['GET', 'POST'])
def projects():
    return render_template('projects.html')

@app.route('/profile', methods=['GET'])
def profile():
    return render_template('profile.html')
