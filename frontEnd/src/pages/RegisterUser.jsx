import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useNavigate } from 'react-router-dom';
import axios from '../config/axios';


const defaultTheme = createTheme();



export default function Register() {
  const navigate = useNavigate();
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    const dataToSend = {
      username: data.get('username'),
      password: data.get('password')
    };
    console.log(dataToSend)
    axios
  .post("/users", dataToSend,{withCredentials: true})
  .then((res) => {
    navigate('/')
  })
  .catch((err) => {
    console.log("Error al intentar autenticar:", err);
  });
    
  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Typography component="h1" variant="h5">
            Register
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="username"
              name="username"
              autoComplete="username"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              
            >
              save

            </Button>
            <Button
              type="submit"
              fullWidth
              variant="outlined"
              sx={{ mt: 2, mb: 2 }}
              onClick={()=>{navigate('/')}}
              
            >
              cancel

            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}