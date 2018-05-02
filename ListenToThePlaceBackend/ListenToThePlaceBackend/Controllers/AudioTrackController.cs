using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using ListenToThePlaceBackend.Models;

namespace TodoApi.Controllers
{
    [Route("api/[controller]")]
    public class AudioTrackController : ControllerBase
    {
        private readonly ListenToThePlaceDBContext _context;

        public AudioTrackController(ListenToThePlaceDBContext context)
        {
            _context = context;

            if (_context.AudioTracks.Count() == 0)
            {
                _context.AudioTracks.Add(new AudioTrackItem { Name = "Imagine", Performer = "John Lennon", Latitude = 52.2201353, Longtitude = 21.0118582 });
                _context.SaveChanges();
            }
        }

        [HttpGet]
        public List<AudioTrackItem> GetAll()
        {
            return _context.AudioTracks.ToList();
        }

        [HttpGet("{id}", Name = "GetAudioTrack")]
        public IActionResult GetById(long id)
        {
            var item = _context.AudioTracks.Find(id);
            if (item == null)
            {
                return NotFound();
            }
            return Ok(item);
        }

        [HttpPost]
        public IActionResult Create([FromBody] AudioTrackItem item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.AudioTracks.Add(item);
            _context.SaveChanges();

            return CreatedAtRoute("GetAudioTrack", new { id = item.Id }, item);
        }

        [HttpPut("{id}")]
        public IActionResult Update(long id, [FromBody] AudioTrackItem item)
        {
            if (item == null || item.Id != id)
            {
                return BadRequest();
            }

            var audioTrack = _context.AudioTracks.Find(id);
            if (audioTrack == null)
            {
                return NotFound();
            }

            audioTrack.Name = item.Name;
            audioTrack.Performer = item.Performer;
            audioTrack.Latitude = item.Latitude;
            audioTrack.Longtitude = item.Longtitude;

            _context.AudioTracks.Update(audioTrack);
            _context.SaveChanges();

            return NoContent();
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(long id)
        {
            var audioTrack = _context.AudioTracks.Find(id);
            if (audioTrack == null)
            {
                return NotFound();
            }

            _context.AudioTracks.Remove(audioTrack);
            _context.SaveChanges();

            return NoContent();
        }
    }
}
